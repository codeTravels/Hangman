package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.ConfigPanel;
import com.mycompany.hangman.model.GameConfig;
import com.mycompany.hangman.model.HangmanGame;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;

/**
 *
 * @author cory.bianchi
 */
public class ConfigController extends AbstractController
{

    private final Component parent;
    private final ConfigPanel view;
    private final PropertyChangeListener listener;

    public ConfigController(Component parent, ConfigPanel view, PropertyChangeListener listener)
    {
        this.parent = parent;
        this.view = view;
        this.listener = listener;
        addView(view);
    }

    public void submit(GameConfig config)
    {
        System.out.println("Submit");
        listener.propertyChange(new PropertyChangeEvent(view, HangmanGame.SET_CONFIG, null, config));
    }

    public void configure()
    {
        System.out.println("Configure()");
        int n = JOptionPane.showOptionDialog(parent,
                                             view,
                                             "Config",
                                             JOptionPane.OK_CANCEL_OPTION,
                                             JOptionPane.PLAIN_MESSAGE,
                                             null,
                                             null,
                                             null);

        if (n == JOptionPane.OK_OPTION)
        {
            submit(view.getUserConfig());
        }
    }
}
