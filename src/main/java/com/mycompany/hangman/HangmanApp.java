package com.mycompany.hangman;

import com.mycompany.hangman.controller.WordController;
import com.mycompany.hangman.gui.HangmanFrame;
import com.mycompany.hangman.model.HangmanGame;

/**
 * Hello world!
 *
 */
public class HangmanApp
{

    public void start()
    {

        HangmanFrame view = new HangmanFrame();
        WordController controller = new WordController(view, new HangmanGame());

        view.addController(controller);
    }


}
