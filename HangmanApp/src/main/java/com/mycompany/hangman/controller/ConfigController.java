package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.ConfigView;
import com.mycompany.hangman.model.GameConfig;
import com.mycompany.hangman.model.HangmanGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author cory.bianchi
 */
public class ConfigController extends AbstractController implements ActionListener
{

    private final ConfigView view;
    private final PropertyChangeListener listener;

    public ConfigController(ConfigView view, PropertyChangeListener listener)
    {
        this.view = view;
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equalsIgnoreCase("config"))
        {
            configure();
        }
        else if (e.getActionCommand().equalsIgnoreCase("submit"))
        {
            submit(((ConfigView) e.getSource()).getUserConfig());
        }

    }

    private void configure()
    {
        view.display();
    }

    private void submit(GameConfig config)
    {
        listener.propertyChange(new PropertyChangeEvent(view, HangmanGame.SET_CONFIG, null, config));
    }
}
