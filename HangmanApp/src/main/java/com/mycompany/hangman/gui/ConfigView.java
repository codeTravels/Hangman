package com.mycompany.hangman.gui;

import com.mycompany.hangman.model.GameConfig;
import java.awt.event.ActionListener;

/**
 *
 * @author cory.bianchi
 */
public interface ConfigView extends View
{

    public GameConfig getUserConfig();

    public void display();

    public void setListener(ActionListener listener);

    public boolean isRestartAllowed();
}
