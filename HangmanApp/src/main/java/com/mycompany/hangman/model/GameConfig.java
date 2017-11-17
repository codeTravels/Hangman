package com.mycompany.hangman.model;

/**
 *
 * @author Cory
 */
public final class GameConfig
{

    public static final int MIN_NUM_GUESSES = 1;
    public static final int MAX_NUM_GUESSES = 10;
    public static final int DEFAULT_NUM_GUESSES = 6;

    private final int numGuessesAllowed;

    public GameConfig()
    {
        numGuessesAllowed = DEFAULT_NUM_GUESSES;
    }

    public GameConfig(int allowedGuesses)
    {
        this.numGuessesAllowed = allowedGuesses;
    }

    public int getNumGuessesAllowed()
    {
        return this.numGuessesAllowed;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof GameConfig))
        {
            return false;
        }
        GameConfig that = (GameConfig) obj;
        return this.getNumGuessesAllowed() == that.numGuessesAllowed;
    }

    @Override
    public int hashCode()
    {
        return this.numGuessesAllowed;
    }

}
