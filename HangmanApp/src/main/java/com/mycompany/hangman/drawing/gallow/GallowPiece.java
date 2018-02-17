package com.mycompany.hangman.drawing.gallow;

import com.mycompany.hangman.drawing.DrawablePiece;
import java.awt.Color;
import java.awt.Graphics;

public abstract class GallowPiece extends DrawablePiece
{

    public GallowPiece(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    protected abstract int getWidth();

    protected abstract int getHeight();
}
