package com.mycompany.hangman.drawing;

import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public abstract class DrawablePiece implements Drawable
{
    private final int x;
    private final int y;
    private boolean show = false;

    public DrawablePiece(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g)
    {

    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean isShowEnabled()
    {
        return show;
    }

    @Override
    public void show()
    {
        show = true;
    }

    @Override
    public void reset()
    {
        show = false;
    }

}
