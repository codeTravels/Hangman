/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cory
 */
public class Word
{

    private List<Character> letters = new ArrayList();
    private int lettersLeftToGuess;

    public Word(String word)
    {
        letters = initialize(word);
        lettersLeftToGuess = word.length();
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
        char[] wordArray = wordToGuess.toCharArray();
        for (int i = 0; i < wordArray.length; i++)
        {
            retVal.add(new Character(wordArray[i]));
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
                letter.setDisplayChar(true);
                lettersLeftToGuess--;
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
        for (Character character : letters)
        {
            char charToDisplay = character.getCharToDisplay();
            builder.append(charToDisplay);
            if (!character.isSpace())
            {
                builder.append(" ");
            }
            else
            {
                builder.append("");
            }
        }
         return builder.toString();
    }

    public int getLettersLeftToGuess()
    {
        return lettersLeftToGuess;
    }

    public boolean hasGuessedWord()
    {
        return !(lettersLeftToGuess > 0);
    }

    @Override
    public String toString()
    {
        StringBuilder retVal = new StringBuilder();
        for (Character letter : letters)
        {
            retVal.append(letter);
        }
        return retVal.toString();
    }

}
