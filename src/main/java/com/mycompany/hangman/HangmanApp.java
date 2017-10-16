package com.mycompany.hangman;

import com.mycompany.hangman.gui.HangmanGui;

/**
 * Hello world!
 *
 */
public class HangmanApp
{

    private final HangmanGui gui = new HangmanGui();

    public void start()
    {
        HangmanGame hangman = new HangmanGame();
        gui.setInputListener(hangman);
        hangman.setPrintArea(gui);
       hangman.setGuessedLetterObserver(gui.getFrame());
        do
        {
            hangman.start();
        }
        while (gui.playAgain());
        gui.gameEnded();
        System.exit(0);
    }


}
