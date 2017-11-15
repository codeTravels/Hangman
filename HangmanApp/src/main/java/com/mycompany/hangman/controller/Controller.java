package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.View;
import com.mycompany.hangman.model.Model;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Cory
 */
public interface Controller extends PropertyChangeListener
{

    public void addModel(Model model);

    public void removeModel(Model model);

    public void addView(View view);

    public void removeView(View view);
}
