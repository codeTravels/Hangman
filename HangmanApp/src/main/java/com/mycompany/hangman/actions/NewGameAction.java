/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.actions;

import com.mycompany.hangman.model.Resetable;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Cory
 */
public class NewGameAction extends AbstractAction
{

    private final Resetable controller;

    public NewGameAction(Resetable controller)
    {
        super("New Game");
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        controller.reset();
    }

}
