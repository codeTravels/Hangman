package com.mycompany.hangman.drawing;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public class Head extends DrawablePiece
{
    private static final int WIDTH = GallowHead.WIDTH;
    protected static  int DIAMETER = 30;

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

    }

}
