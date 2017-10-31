package com.mycompany.hangman.drawing;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public class LeftLeg extends DrawablePiece
{

    public LeftLeg(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        double slope = 1;
        int x2 = 25;
        double y2=slope*x2 + getY();
        int offset = getX();
        g.drawLine(getX(), getY(), offset - x2, (int)y2);

    }

}
