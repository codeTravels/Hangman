/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.menu;

import com.mycompany.hangman.actions.ExitAction;
import com.mycompany.hangman.actions.NewGameAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import com.mycompany.hangman.actions.ActionRepository;

/**
 *
 * @author Cory
 */
public class GameMenu extends JMenu
{
    public GameMenu(ActionRepository actionRepo)
    {
        super("Game");
        create(actionRepo);
    }

    private void create(ActionRepository actionRepo)
    {
        Action action = actionRepo.get(NewGameAction.class);
        JMenuItem jMenuItem = new JMenuItem(action);
        add(jMenuItem);

        add(new JSeparator());

        action = actionRepo.get(ExitAction.class);
        jMenuItem = new JMenuItem(action);
        add(jMenuItem);
    }
}
