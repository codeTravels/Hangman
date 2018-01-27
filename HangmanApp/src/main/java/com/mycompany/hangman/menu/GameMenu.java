package com.mycompany.hangman.menu;

import com.mycompany.hangman.actions.ActionManager;
import java.util.Map;
import javax.swing.Action;
import javax.swing.JMenu;

/**
 *
 * @author Cory
 */
public class GameMenu extends JMenu
{

    public GameMenu(Map<String, Action> map)
    {
        super("Game");
        create(map);
    }

    private void create(Map<String, Action> map)
    {
        add(map.get(ActionManager.NEW_GAME_ACTION));
        add(map.get(ActionManager.CONFIG_GAME_ACTION));

        addSeparator();

        add(map.get(ActionManager.EXIT_GAME_ACTION));
    }
}
