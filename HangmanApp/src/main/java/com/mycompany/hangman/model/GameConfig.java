package com.mycompany.hangman.model;

/**
 *
 * @author Cory
 */
public class GameConfig
{

    public static final int MIN_NUM_GUESSES = 1;
    public static final int MAX_NUM_GUESSES = 10;
    public static final int DEFAULT_NUM_GUESSES = 6;

    private int numGuessesAllowed = DEFAULT_NUM_GUESSES;

    public GameConfig()
    {
    }

    public void setNumGuessesAllowed(int numGuessesAllowed)
    {
        this.numGuessesAllowed = numGuessesAllowed;
    }

    public int getNumGuessesAllowed()
    {
        return numGuessesAllowed;
    }
}
