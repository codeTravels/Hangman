/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.controller;

import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.gui.HangmanFrame;
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

        this.view.updateGuessedLetters(model.getGuessedLetters());
        for (String string : model.getOutputText())
        {
            view.println(string);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("WordController actionPerformed");
        String text = view.getTextField().getText();
        view.getTextField().setText("");
        if (!text.isEmpty())
        {

            if (isALetter(text.charAt(0)))
            {
                model.processLetter(text.charAt(0));

                for (String string : model.getOutputText())
                {
                    view.println(string);
                }
                view.updateGuessedLetters(model.getGuessedLetters());

                    if (model.hasEnded())
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
            else
            {
                view.println("Please make a valid guess. Choose between a-z.");
            }
        }
    }
    protected boolean isALetter(char character)
    {
        //return ((character - 'a' ) < 26) || ((character - 'A') < 26);
        return ('a' <= character) && (character <= 'z');
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


    public void reset()
    {
         this.model.reset();

        this.view.updateGuessedLetters(model.getGuessedLetters());
        for (String string : model.getOutputText())
        {
            view.println(string);
        }
    }

}
