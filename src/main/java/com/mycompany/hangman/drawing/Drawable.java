package com.mycompany.hangman.drawing;

import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public interface Drawable
{
    public void draw(Graphics g);

    public boolean isShowEnabled();

    public void reset();

    public void show();
}
