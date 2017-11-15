package com.mycompany.hangman.drawing;

import com.mycompany.hangman.model.Resetable;
import java.awt.Graphics;

/**
 *
 * @author Cory
 */
public interface Drawable extends Resetable
{
    public void draw(Graphics g);

    public boolean isShowEnabled();

    public void show();
}
