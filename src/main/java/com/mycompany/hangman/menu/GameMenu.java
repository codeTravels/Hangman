/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.menu;

import com.mycompany.hangman.actions.ActionsRepository;
import com.mycompany.hangman.actions.ExitAction;
import com.mycompany.hangman.actions.NewGameAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author Cory
 */
public class GameMenu extends JMenu
{
    public GameMenu(ActionsRepository repo)
    {
        super("Game");
        create(repo);
    }

    private void create(ActionsRepository repo)
    {
        Action action = repo.get(NewGameAction.class);
        JMenuItem jMenuItem = new JMenuItem(action);
        add(jMenuItem);

        add(new JSeparator());

        action = repo.get(ExitAction.class);
        jMenuItem = new JMenuItem(action);
        add(jMenuItem);
    }
}
