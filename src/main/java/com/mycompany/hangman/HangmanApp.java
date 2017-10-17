package com.mycompany.hangman;

import com.mycompany.hangman.gui.HangmanGui;

/**
 * Hello world!
 *
 */
public class HangmanApp implements GameObserver
{

    private final HangmanGui gui = new HangmanGui();
    private final HangmanGame hangman = new HangmanGame();

    public void start()
    {
        gui.setInputListener(hangman);
        hangman.setPrintArea(gui.getFrame());
        hangman.setGuessedLetterObserver(gui.getFrame());
        hangman.setGameObserver(this);
        hangman.start();
    }


    @Override
    public void onGameEnded()
    {
         if (gui.playAgain())
        {
            hangman.reset();
        }
        else
        {
            gui.gameEnded();
            System.exit(0);
        }
    }


}
