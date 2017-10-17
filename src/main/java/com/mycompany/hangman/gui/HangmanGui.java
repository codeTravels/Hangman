/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.gui;

import com.mycompany.hangman.InputListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Cory
 */
public class HangmanGui implements ActionObserver
{

    HangmanFrame hangmanFrame = new HangmanFrame();
    InputListener inputListener;

    public HangmanGui()
    {
        this.hangmanFrame.setActionObserver(this);
    }

    public HangmanFrame getFrame()
    {
        return this.hangmanFrame;
    }

    public void textEntered()
    {
        String text = getFrame().getTextField().getText();
        getFrame().getTextField().setText("");
        if (!text.isEmpty())
        {
            inputListener.inputEvent(text.charAt(0));
        }
    }

    public void setInputListener(InputListener listener)
    {
        this.inputListener = listener;
    }

    public boolean playAgain()
    {
        boolean retVal = false;
        Object options[] =
        {
            "Yes please", "No, thanks"
        };

        int n = JOptionPane.showOptionDialog(getFrame(),
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

    public void gameEnded()
    {
        this.hangmanFrame.println("Thanks for playing! Come back soon.");
    }
}
