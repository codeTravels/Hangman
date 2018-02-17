package com.mycompany.hangman.drawing;

import com.mycompany.hangman.model.Resetable;
import java.awt.Graphics;

public interface Drawable extends Resetable
{

    void draw(Graphics g);

    boolean isShowEnabled();

    void show();
}
