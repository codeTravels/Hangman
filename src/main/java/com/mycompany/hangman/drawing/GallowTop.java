/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.drawing;


/**
 *
 * @author Cory
 */
public class GallowTop extends GallowPiece
{
    protected static int WIDTH = 75;
    protected static int HEIGHT = 5;

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
