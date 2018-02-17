package com.mycompany.hangman.drawing;

import com.mycompany.hangman.drawing.body.Head;
import com.mycompany.hangman.drawing.body.LeftArm;
import com.mycompany.hangman.drawing.body.LeftLeg;
import com.mycompany.hangman.drawing.body.RightArm;
import com.mycompany.hangman.drawing.body.RightLeg;
import com.mycompany.hangman.drawing.body.Torso;
import com.mycompany.hangman.drawing.gallow.GallowBase;
import com.mycompany.hangman.drawing.gallow.GallowHead;
import com.mycompany.hangman.drawing.gallow.GallowPost;
import com.mycompany.hangman.drawing.gallow.GallowTop;
import com.mycompany.hangman.model.GameConfig;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cory
 */
public class Picture implements Drawable
{

    private int chancesToGuess = GameConfig.DEFAULT_NUM_GUESSES;
    private final List<Drawable> drawables = new ArrayList<>();
    private int cnt;

    public Picture(int width, int height)
    {
        this(width, height, 0);
    }

    public Picture(int width, int height, int offset)
    {
        GallowBase gallowBase = new GallowBase((width - GallowBase.WIDTH) / 2 + offset,
                                               height - GallowBase.HEIGHT);

        drawables.add(gallowBase);

        GallowPost gallowPost = new GallowPost(gallowBase.getX() + (GallowBase.WIDTH - GallowPost.WIDTH) / 2,
                                               gallowBase.getY() - GallowPost.HEIGHT);
        drawables.add(gallowPost);

        GallowTop gallowTop = new GallowTop(gallowPost.getX() + GallowPost.WIDTH - GallowTop.WIDTH,
                                            gallowPost.getY() - GallowTop.HEIGHT);
        drawables.add(gallowTop);

        GallowHead gallowHead = new GallowHead(gallowTop.getX(), gallowTop.getY() + GallowTop.HEIGHT);
        drawables.add(gallowHead);

        Head head = new Head(gallowHead.getX(), gallowHead.getY() + GallowHead.HEIGHT);
        drawables.add(head);

        Torso torso = new Torso(head.getX(), head.getY() + Head.DIAMETER);
        drawables.add(torso);

        LeftArm leftArm = new LeftArm(torso.getX(), torso.getY() + Torso.HEIGHT / 2);
        drawables.add(leftArm);

        RightArm rightArm = new RightArm(torso.getX(), torso.getY() + Torso.HEIGHT / 2);
        drawables.add(rightArm);

        LeftLeg leftLeg = new LeftLeg(torso.getX(), torso.getY() + Torso.HEIGHT);
        drawables.add(leftLeg);

        RightLeg rightLeg = new RightLeg(torso.getX(), torso.getY() + Torso.HEIGHT);
        drawables.add(rightLeg);

        cnt = drawables.size() - chancesToGuess;
        for (int i = 0; i < cnt; i++)
        {
            drawables.get(i).show();
        }
    }

    public void showEnableNext()
    {
        if (cnt <= drawables.size())
        {
            drawables.get(cnt++).show();
        }
    }

    @Override
    public void draw(Graphics g)
    {
        for (Drawable drawable : drawables)
        {
            if (drawable.isShowEnabled())
            {
                drawable.draw(g);
            }
        }
    }

    @Override
    public void reset()
    {
        drawables.forEach((drawable) ->
        {
            drawable.reset();
        });
        cnt = drawables.size() - chancesToGuess;
        for (int i = 0; i < cnt; i++)
        {
            drawables.get(i).show();
        }
    }

    @Override
    public boolean isShowEnabled()
    {
        boolean retVal = true;
        for (Drawable drawable : drawables)
        {
            if (!drawable.isShowEnabled())
            {
                retVal = false;
                break;
            }
        }
        return retVal;
    }

    @Override
    public void show()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setChancesToGuess(int chancesToGuess)
    {
        this.chancesToGuess = chancesToGuess;
    }

}
