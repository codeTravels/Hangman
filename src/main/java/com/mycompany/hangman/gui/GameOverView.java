package com.mycompany.hangman.gui;

import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.model.Resetable;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Cory
 */
public class GameOverView implements View
{

    private final Component parent;
    private final Resetable resetable;

    public GameOverView(Component parent, Resetable resetable)
    {
        this.parent = parent;
        this.resetable = resetable;
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt)
    {
        if (evt.getPropertyName().equals(HangmanGame.GAME_OVER))
        {
            handleGameOver();
        }
    }

    private void handleGameOver()
    {
        if (playAgain())
        {
            resetable.reset();
        }
        else
        {
            System.exit(0);
        }
    }

    public boolean playAgain()
    {
        boolean retVal = false;
        Object options[] =
        {
            "Yes please", "No, thanks"
        };

        int n = JOptionPane.showOptionDialog(parent,
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

}
