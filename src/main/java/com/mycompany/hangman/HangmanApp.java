package com.mycompany.hangman;

import com.mycompany.hangman.controller.WordController;
import com.mycompany.hangman.drawing.Picture;
import com.mycompany.hangman.drawing.DefaultPictureController;
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
        HangmanGame game = new HangmanGame(view.getDrawPanel().getPicture());
        WordController controller = new WordController(view, game);

        view.addController(controller);

//        DefaultPictureController pictureController = new DefaultPictureController(view.getDrawPanel(),
//                new Picture(view.getDrawPanel().getWidth(), view.getDrawPanel().getHeight(), 10));
//
//        view.getDrawPanel().setPictureController(pictureController);
    }


}
