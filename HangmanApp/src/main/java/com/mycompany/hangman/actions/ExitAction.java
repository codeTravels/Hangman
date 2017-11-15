/*
 *   To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Cory
 */
public class ExitAction extends AbstractAction
{

    public ExitAction()
    {
        super("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
           System.exit(0);
    }

}
