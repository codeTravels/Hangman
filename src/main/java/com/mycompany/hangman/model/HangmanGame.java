/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.model;

import java.util.*;

/**
 *
 * @author Cory
 */
public class HangmanGame extends AbstractModel
{
    public final static String GUESSED_LETTER = "GUESSED_LETTER";
    public final static String WORD = "WORD";
    public final static String OUT_TEXT = "OUT_TEXT";
    public final static String CLEAR_OUT_TEXT = "CLEAR_OUT_TEXT";
    public final static String GAME_OVER = "GAME_OVER";

    private final List<Character> guessedLetters = new ArrayList();
    private Word wordToGuess;
    private final DisplayedDrawing picture;

    public HangmanGame(DisplayedDrawing picture)
    {
        this.picture = picture;
        reset(new WordGenerator().generateWord());
    }

    public final void reset(Word word)
    {
        wordToGuess = word;
        firePropertyChange(WORD, null, wordToGuess.displayString() );
        picture.reset();
        guessedLetters.clear();
        firePropertyChange(GUESSED_LETTER, null, getGuessedLetters());
        firePropertyChange(CLEAR_OUT_TEXT, false, true);
    }

    public void processLetter(char guessedLetter)
    {
        Collection<String> outputText= new LinkedList<>();
        wordToGuess.guessedCorrectLetter(guessedLetter);
        firePropertyChange(WORD, null, wordToGuess.displayString() );

        if (wordToGuess.hasGuessedWord())
        {
            outputText.add("Great, you have figured out the word! It is " + wordToGuess + ".");
        }
        else if (Word.hasLetter(guessedLetter, guessedLetters))
        {
            outputText.add("You already guessed the letter '" + guessedLetter + "'.");
        }
        else if (wordToGuess.hasLetter(guessedLetter))
        {
            outputText.add("Great guess you got one!");
        }
        else
        {
            picture.showEnableNext();
            outputText.add("Sorry, wrong guess.");

            if (picture.doneDrawing())
            {
                outputText.add("You Lose. The word was " + wordToGuess+".");
            }
        }
        addGuessedLetterToList(guessedLetter);
        firePropertyChange(OUT_TEXT, null , outputText);
        firePropertyChange(GAME_OVER, false, gameOver());

    }

    /**
     * Add letter to list of guessed letters
     *
     * @param letter letter that was guessed
     */
    private void addGuessedLetterToList(char letter)
    {
        guessedLetters.add(new Character(letter));
        firePropertyChange(GUESSED_LETTER, null, getGuessedLetters() );
    }


    public List<Character> getGuessedLetters()
    {
        return new ArrayList<>(guessedLetters);
    }

    public String getDisplayString()
    {
        return wordToGuess.displayString();
    }

    public boolean gameOver()
    {
        return wordToGuess.hasGuessedWord() || picture.doneDrawing();
    }

}
