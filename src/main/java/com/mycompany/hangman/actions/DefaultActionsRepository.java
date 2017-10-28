/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.actions;

import java.util.HashMap;
import java.util.Map;
import javax.swing.Action;

/**
 *
 * @author Cory
 */
public class DefaultActionsRepository implements ActionsRepository
{
    private final Map<String, Action> actions = new HashMap<>();

    @Override
    public Action get(Class<?> controllerClass)
    {
        return get(controllerClass.getName());
    }

    @Override
    public Action get(String name)
    {
        return actions.get(name);
    }

    @Override
    public void add(Action action)
    {
        put(action.getClass().getName(), action);
    }

    @Override
    public void put(String name, Action action)
    {
        actions.put(name, action);
    }

}
