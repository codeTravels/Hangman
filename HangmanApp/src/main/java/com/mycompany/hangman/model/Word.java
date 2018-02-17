package com.mycompany.hangman.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Word
{

    private final List<Character> letters = new ArrayList();

    /**
     * Creates a Word object from a String.
     *
     * @param word the string to convert
     */
    public Word(String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            letters.add(new Character(word.charAt(i)));
        }
    }

    /**
     * Check if guessed letter is part of the word and is not currently
     * displayed. If it is then the letter will be able to be displayed.
     *
     * @param guessedLetter the letter to look for
     * @return true if the guessed letter is not currently displayed and is part
     *         of the word. false if the letter is already displaying or is not
     *         part of the word
     *
     */
    public boolean guessedCorrectLetter(char guessedLetter)
    {
        boolean retVal = false;
        for (Character letter : letters)
        {
            if (guessedLetter == letter.get() && !letter.ableToDisplay())
            {
                retVal = true;
                letter.displayChar();
            }
        }
        return retVal;
    }

    /**
     * Checks if the char is part of the word.
     *
     * @param guessedLetter the letter to search for
     * @return true if guessedLetter is in this word
     */
    public boolean hasLetter(char guessedLetter)
    {
        return hasLetter(guessedLetter, letters);
    }

    /**
     * Checks if the guessedLetter is part of the list of Characters.
     *
     * @param guessedLetter the letter to search for
     * @param letters       the list to look in
     * @return true if guessedLetter is in letters
     */
    public static boolean hasLetter(char guessedLetter, List<Character> letters)
    {
        boolean retVal = false;
        for (Character letter : letters)
        {
            if (guessedLetter == letter.get())
            {
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    /**
     * The formatted string that is displayed to the user.
     *
     * @return the formatted string
     */
    public String displayString()
    {
        StringBuilder builder = new StringBuilder();
        for (Iterator<Character> it = letters.iterator(); it.hasNext();)
        {
            Character character = it.next();
            char charToDisplay = character.getCharToDisplay();
            builder.append(charToDisplay);
            if (it.hasNext())
            {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * Checks to see if the whole word has been guessed.
     *
     * @return true if the whole word has been guessed
     */
    public boolean hasGuessedWord()
    {
        boolean retVal = true;
        for (Character letter : letters)
        {
            if (!letter.ableToDisplay())
            {
                retVal = false;
                break;
            }
        }
        return retVal;
    }

    /**
     * Checks if the given char is currently displaying.
     *
     * @param letter the letter to check
     * @return true if the letter is being displayed
     */
    public boolean isDisplaying(char letter)
    {
        boolean retVal = false;
        for (Character letter1 : letters)
        {
            if (letter1.getCharToDisplay() == letter)
            {
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    @Override
    public String toString()
    {
        StringBuilder retVal = new StringBuilder();
        letters.forEach((letter) ->
        {
            retVal.append(letter);
        });
        return retVal.toString();
    }

}
