/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.drawing;

import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public abstract class DrawablePiece implements Drawable
{
    final private int x;
    final private int y;
    private boolean show = false;

    public DrawablePiece(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g)
    {

    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean isShowEnabled()
    {
        return show;
    }

    @Override
    public void show()
    {
        show = true;
    }

    @Override
    public void reset()
    {
        show = false;
    }

}
