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
public class Torso extends DrawablePiece
{
    protected static int WIDTH = 2;
    protected static int HEIGHT = 60;

    public Torso(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.drawLine(getX(), getY(), getX(), getY() + HEIGHT);

    }

}
