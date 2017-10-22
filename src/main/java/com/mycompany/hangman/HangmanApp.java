package com.mycompany.hangman;

import com.mycompany.hangman.controller.WordController;
import com.mycompany.hangman.drawing.Picture;
import com.mycompany.hangman.drawing.DefaultPictureController;
import com.mycompany.hangman.gui.GameOverView;
import com.mycompany.hangman.gui.HangmanFrame;
import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.model.WordGenerator;

/**
 * Hello world!
 *
 */
public class HangmanApp
{

    public void start()
    {

        HangmanFrame view = new HangmanFrame();
        HangmanGame game = new HangmanGame(new WordGenerator(), view.getDrawPanel().getPicture());
        WordController controller = new WordController(view, game);

        view.addController(controller);

        GameOverView gov = new GameOverView(view, controller);
        controller.addView(gov);

    }


}
