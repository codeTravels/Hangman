package com.mycompany.hangman;

import com.mycompany.hangman.actions.ActionRepository;
import com.mycompany.hangman.actions.DefaultActionRepository;
import com.mycompany.hangman.actions.ExitAction;
import com.mycompany.hangman.actions.NewGameAction;
import com.mycompany.hangman.controller.WordController;
import com.mycompany.hangman.gui.GameOverView;
import com.mycompany.hangman.gui.HangmanFrame;
import com.mycompany.hangman.menu.GameMenu;
import com.mycompany.hangman.model.HangmanGame;
import com.mycompany.hangman.model.WordGenerator;
import javax.swing.JMenuBar;

/**
 * Hello world!
 *
 */
public class HangmanApp
{

    public void start()
    {

        HangmanFrame view = new HangmanFrame();
        HangmanGame game = new HangmanGame(new WordGenerator());
        WordController controller = new WordController(view, game);
        controller.addView(view.getDrawPanel());
        view.addController(controller);

        GameOverView gov = new GameOverView(view, controller);
        controller.addView(gov);

        ActionRepository actionRepo = new DefaultActionRepository();
        {
            actionRepo.add(new NewGameAction(controller));
            actionRepo.add(new ExitAction());
        }

        {
            JMenuBar jMenuBar = new JMenuBar();
            jMenuBar.add(new GameMenu(actionRepo));
            view.setJMenuBar(jMenuBar);
            view.pack();
        }
    }


}
