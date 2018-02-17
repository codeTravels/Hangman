package com.mycompany.hangman.drawing.body;

import com.mycompany.hangman.drawing.DrawablePiece;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public class RightArm extends DrawablePiece
{

    public RightArm(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        double slope = -1;
        int offset = getX();
        int x2 = offset + 25;
        double y2 = slope * (x2 - offset) + getY();
        g.drawLine(getX(), getY(), x2, (int) y2);

    }

}
