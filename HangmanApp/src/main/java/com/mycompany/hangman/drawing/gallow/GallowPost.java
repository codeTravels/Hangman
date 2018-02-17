package com.mycompany.hangman.drawing.gallow;

public class GallowPost extends GallowPiece
{

    public static final int WIDTH = 5;
    public static final int HEIGHT = 150;

    public GallowPost(int x, int y)
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
