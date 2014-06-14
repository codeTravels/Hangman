package com.mycompany.hangman;

import com.mycompany.hangman.gui.HangmanGui;

/**
 * Hello world!
 *
 */
public class HangmanApp
{

    private HangmanGui gui = new HangmanGui();

    public void start()
    {
        HangmanGame hangman = new HangmanGame();
        gui.setInputListener(hangman);
        hangman.setPrintArea(gui);
        do
        {
            hangman.start();
        }
        while (gui.playAgain());
        gui.gameEnded();
    }

    
}
