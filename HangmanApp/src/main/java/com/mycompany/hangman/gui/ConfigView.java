package com.mycompany.hangman.gui;

import com.mycompany.hangman.model.GameConfig;
import java.awt.event.ActionListener;

/**
 *
 * @author cory.bianchi
 */
public interface ConfigView extends View
{

    GameConfig getUserConfig();

    void display();

    void setListener(ActionListener listener);

    boolean isRestartAllowed();
}
