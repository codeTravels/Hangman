package com.mycompany.hangman.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

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
