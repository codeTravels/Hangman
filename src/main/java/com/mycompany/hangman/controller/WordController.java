/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.HangmanFrame;
import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.model.Resetable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cory
 */
public class WordController extends AbstractController implements ActionListener, Resetable
{

    private final HangmanFrame view;
    private final HangmanGame model;

    public WordController(HangmanFrame view, HangmanGame model)
    {
        this.view = view;
        this.model = model;

        addModel(model);
        addView(view);

        view.setWordToGuess(model.getDisplayString());
        view.setGuessedLetters(model.getGuessedLetters());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String guess = view.getGuess();
        view.clearGuess();
        if (!guess.isEmpty())
        {
            model.processLetter(guess.charAt(0));
        }
    }

    @Override
    public void reset()
    {
        this.model.reset();
    }
}
