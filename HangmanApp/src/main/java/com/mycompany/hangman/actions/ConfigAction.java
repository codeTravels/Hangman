package com.mycompany.hangman.actions;

import com.mycompany.hangman.controller.ConfigController;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author cory.bianchi
 */
public class ConfigAction extends AbstractAction
{

    private final ConfigController controller;

    public ConfigAction(ConfigController controller)
    {
        super("Config");
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.controller.configure();
    }

}
