package com.mycompany.hangman.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;

/**
 *
 * @author cory.bianchi
 */
public class ConfigAction extends AbstractAction
{

    private final ActionListener controller;

    public ConfigAction(ActionListener controller)
    {
        super("Config");
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.controller.actionPerformed(e);
    }

}
