package com.mycompany.hangman.model;

import java.beans.PropertyChangeListener;

/**
 *
 * @author Cory
 */
public interface Model
{
    public void addPropertyChangeListener(PropertyChangeListener listener);

    public void removePropertyChangeListener(PropertyChangeListener listener) ;
}
