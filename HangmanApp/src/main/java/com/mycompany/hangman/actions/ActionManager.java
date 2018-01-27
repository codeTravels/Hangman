package com.mycompany.hangman.actions;

import java.util.HashMap;
import java.util.Map;
import javax.swing.Action;

/**
 *
 * @author Cory
 */
public class ActionManager
{

    private static volatile ActionManager instance;
    public static final String NEW_GAME_ACTION = "NEW_GAME";
    public static final String CONFIG_GAME_ACTION = "CONFIG_GAME";
    public static final String EXIT_GAME_ACTION = "EXIT_GAME";

    private final Map<String, Action> actions = new HashMap<>();

    private ActionManager()
    {
    }

    public synchronized static ActionManager getInstance()
    {
        if (instance == null)
        {
            instance = new ActionManager();
        }
        return instance;
    }

    public Action get(String key)
    {
        return actions.get(key);
    }

    public void put(String key, Action value)
    {
        actions.put(key, value);
    }

    public Map<String, Action> getMapping()
    {
        return new HashMap(this.actions);
    }
}
