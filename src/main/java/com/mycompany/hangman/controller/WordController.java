/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.controller;

import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.gui.HangmanFrame;
import com.mycompany.hangman.model.WordGenerator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Cory
 */
public class WordController implements ActionListener
{

    private final HangmanFrame view;
    private final HangmanGame model;

    public WordController(HangmanFrame view, HangmanGame model)
    {
        this.view = view;
        this.model = model;

        updateViewFromModel();
    }

    private void updateViewFromModel()
    {
        view.setGuessedLetters(model.getGuessedLetters());
        view.setWordToGuess(model.getDisplayString());
        for (String string : model.getOutputText())
        {
            view.println(string);
        }
        view.getDrawPanel().repaint(); // TODO move to another class?
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("WordController actionPerformed");

        String guess = view.getGuess();
        view.clearGuess();
        if (!guess.isEmpty())
        {
            model.processLetter(guess.charAt(0));
        }

        updateViewFromModel();

        if (model.gameOver())
        {
            if (playAgain())
            {
                reset();
            }
            else
            {
                 this.view.println("Thanks for playing! Come back soon.");
                System.exit(0);
            }
        }
    }

    public boolean playAgain()
    {
        boolean retVal = false;
        Object options[] =
        {
            "Yes please", "No, thanks"
        };

        int n = JOptionPane.showOptionDialog(view,
                                             "Do you want to play again?",
                                             "Game Over",
                                             JOptionPane.YES_NO_OPTION,
                                             JOptionPane.QUESTION_MESSAGE,
                                             null, //do not use a custom Icon
                                             options, //the titles of buttons
                                             options[0]); //default button title
        if (n == 0)
        {
            retVal = true;
        }
        return retVal;
    }

    private void reset()
    {
        view.clearOutputConsole();
        this.model.reset(new WordGenerator().generateWord());
        updateViewFromModel();
    }

}
