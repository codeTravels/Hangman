/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.actions;

import com.mycompany.hangman.repo.Repository;
import javax.swing.Action;

/**
 *
 * @author Cory
 */
public interface ActionRepository extends Repository<Action>
{
    @Override
    public Action get(Class<?> actionClass);

    @Override
    public Action get(String name);

    @Override
    public void add(Action action);

    @Override
    public void put(String name, Action action);
}