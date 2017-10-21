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
public class HangmanGame
{

    private final List<Character> guessedLetters = new ArrayList();
    private Word wordToGuess;
    private final Queue<String> outputText= new LinkedList<>();
    private final DisplayedDrawing picture;

    public HangmanGame(DisplayedDrawing picture)
    {
        this.picture = picture;
        reset(new WordGenerator().generateWord());
    }

    public final void reset(Word word)
    {
        wordToGuess = word;
        picture.reset();
        guessedLetters.clear();
        outputText.clear();
    }

    public void processLetter(char guessedLetter)
    {

        wordToGuess.guessedCorrectLetter(guessedLetter);

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

    }

    /**
     * Add letter to list of guessed letters
     *
     * @param letter letter that was guessed
     */
    private void addGuessedLetterToList(char letter)
    {
        guessedLetters.add(new Character(letter));
    }

    public List<String> getOutputText()
    {
        List<String> retVal = new ArrayList<>(outputText);
        outputText.clear();
        return retVal;
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
