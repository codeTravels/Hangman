package com.mycompany.hangman.drawing.gallow;

/**
 *
 * @author Cory
 */
public class GallowBase extends GallowPiece
{

    public static final int WIDTH = 100;
    public static final int HEIGHT = 10;

    public GallowBase(int x, int y)
    {
        super(x, y);
    }

    @Override
    protected int getWidth()
    {
        return WIDTH;
    }

    @Override
    protected int getHeight()
    {
        return HEIGHT;
    }

}
