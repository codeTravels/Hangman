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
public class GallowHead extends GallowPiece
{
    protected static int WIDTH = 5;
    protected static int HEIGHT = 20;

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
