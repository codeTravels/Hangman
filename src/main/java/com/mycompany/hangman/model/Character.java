/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.model;

/**
 *
 * @author Cory
 */
public class Character
{

    protected static char PLACE_HOLDER = '_';
    private char character;
    private boolean displayChar = false;

    public Character(char character)
    {
        this.character = character;
        displaySpaceChar();
    }

    public char get()
    {
        return this.character;
    }

    public char getCharToDisplay()
    {
        if (ableToDisplay())
        {
            return get();
        }
        else
        {
            return PLACE_HOLDER;
        }
    }

    public void setDisplayChar(boolean display)
    {
        this.displayChar = display;
    }

    public boolean ableToDisplay()
    {
        return displayChar;
    }
    /**
     * Displays character if it is a space
     */
    protected final void displaySpaceChar()
    {
        if (get() == ' ')
        {
            setDisplayChar(true);
        }
    }
    /**
     * Returns true if it is a space character
     * @return
     */
    public boolean isSpace()
    {
        return get() == ' ';
    }

    @Override
    public String toString()
    {
        return String.valueOf(character);
    }
}
