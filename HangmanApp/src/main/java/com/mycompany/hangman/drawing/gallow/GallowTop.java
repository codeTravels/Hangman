package com.mycompany.hangman.drawing.gallow;

/**
 *
 * @author Cory
 */
public class GallowTop extends GallowPiece
{

    public static final int WIDTH = 75;
    public static final int HEIGHT = 5;

    public GallowTop(int x, int y)
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
