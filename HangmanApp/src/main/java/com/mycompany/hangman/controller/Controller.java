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

    void addModel(Model model);

    void removeModel(Model model);

    void addView(View view);

    void removeView(View view);
}
