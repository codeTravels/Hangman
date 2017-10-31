package com.mycompany.hangman.model;

/**
 *
 * @author Cory
 */
public class Character
{

    protected static char PLACE_HOLDER = '_';
    private final char character;
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
        return ableToDisplay() ? get() : PLACE_HOLDER;
    }

    public void displayChar()
    {
        this.displayChar = true;
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
            displayChar();
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
