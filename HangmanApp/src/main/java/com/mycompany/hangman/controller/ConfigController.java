package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.ConfigView;
import com.mycompany.hangman.model.HangmanGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cory.bianchi
 */
public class ConfigController extends AbstractController implements ActionListener
{

    private final ConfigView view;
    private final HangmanGame model;

    public ConfigController(ConfigView view, HangmanGame model)
    {
        this.view = view;
        this.model = model;
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
            submit();
        }

    }

    private void configure()
    {
        view.display();
    }

    private void submit()
    {
        if (view.isRestartAllowed())
        {
            model.start(view.getUserConfig());
        }
    }
}
