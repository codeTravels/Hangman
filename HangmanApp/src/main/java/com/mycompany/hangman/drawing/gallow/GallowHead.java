package com.mycompany.hangman.drawing.gallow;

/**
 *
 * @author Cory
 */
public class GallowHead extends GallowPiece
{
    public static int WIDTH = 5;
    public static int HEIGHT = 20;

    public GallowHead(int x, int y)
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
