/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.drawing;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public class RightLeg extends DrawablePiece
{

    public RightLeg(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        double slope = 1;
        int offset = getX();
        int x2 = offset + 25;
        double y2 = slope*(x2 - offset) + getY();
        g.drawLine(getX(), getY(), x2, (int)y2);

    }
}
