package com.mycompany.hangman.drawing;

import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public abstract class DrawablePiece implements Drawable
{
    private final int xCoordinate;
    private final int yCoordinate;
    private boolean show = false;

    public DrawablePiece(int x, int y)
    {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    @Override
    public void draw(Graphics g)
    {

    }

    public int getX()
    {
        return xCoordinate;
    }

    public int getY()
    {
        return yCoordinate;
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
