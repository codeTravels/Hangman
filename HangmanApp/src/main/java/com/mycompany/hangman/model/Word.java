package com.mycompany.hangman.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Cory
 */
public class Word
{

    private List<Character> letters = new ArrayList();

    public Word(String word)
    {
        letters = initialize(word);
    }

    /**
     * Creates a list of characters from the wordToGuess
     *
     * @param wordToGuess
     * @return the list of characters from the word to guess
     */
    protected final List<Character> initialize(String wordToGuess)
    {
        List<Character> retVal = new ArrayList();
        for (int i = 0; i < wordToGuess.length(); i++)
        {
            retVal.add(new Character(wordToGuess.charAt(i)));
        }
        return retVal;
    }

    /**
     * Check if guessed letter is part of the word and is not currently
     * displayed. If it is then the letter will be able to be displayed.
     *
     * @param guessedLetter
     * @return true if the guessed letter is not currently displayed and is part
     * of the word. false if the letter is already displaying or is not part of
     * the word
     *
     */
    public boolean guessedCorrectLetter(char guessedLetter)
    {
        boolean retVal = false;
        for (Character letter : letters)
        {
            if (guessedLetter == letter.get() && (!letter.ableToDisplay()))
            {
                retVal = true;
                letter.displayChar();
            }
        }
        return retVal;
    }

    /**
     * Checks if the char is part of the word
     *
     * @param guessedLetter
     * @return
     */
    public boolean hasLetter(char guessedLetter)
    {
        return hasLetter(guessedLetter, letters);
    }

    /**
     * Checks if the guessedLetter is part of the list of Characters
     *
     * @param guessedLetter
     * @param letters
     * @return
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
