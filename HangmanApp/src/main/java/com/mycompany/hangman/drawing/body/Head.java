package com.mycompany.hangman.drawing.body;

import com.mycompany.hangman.drawing.DrawablePiece;
import com.mycompany.hangman.drawing.gallow.GallowHead;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public class Head extends DrawablePiece
{
    public static final int WIDTH = GallowHead.WIDTH;
    public static  int DIAMETER = 30;

    public Head(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.drawOval(getX() - ((DIAMETER - WIDTH)/2), getY(), DIAMETER, DIAMETER);

        // Draw eyes
        char [] data = {'x'};
        int leftEyeX = getX();
        int eyeY = getY() + (int)(DIAMETER * 0.33);
        g.drawChars(data, 0, data.length, leftEyeX - 3, eyeY + 5);

        int rightEyeX = getX() + (int)(DIAMETER * 0.33);
        g.drawChars(data, 0, 1, rightEyeX - 3, eyeY + 5);

    }

}
