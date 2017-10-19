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

    protected static final int CHANCES_TO_GUESS = 5;
    private int chancesLeftToGuess;
    private final List<Character> guessedLetters = new ArrayList();
    private Word wordToGuess;
    private final Queue<String> outputText= new LinkedList<String>();

    public HangmanGame()
    {
        reset(new WordGenerator().generateWord());
    }

    public final void reset(Word word)
    {
        wordToGuess = word;
        chancesLeftToGuess = CHANCES_TO_GUESS;
        guessedLetters.clear();
        outputText.clear();
        outputText.add(wordToGuess.displayString());
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
            outputText.add("You already guessed the letter '" + guessedLetter + "'. So far you have");
            outputText.add( wordToGuess.displayString());
        }
        else if (wordToGuess.hasLetter(guessedLetter))
        {
            outputText.add("Great guess you got one!");
            outputText.add( wordToGuess.displayString());
        }
        else
        {
            chancesLeftToGuess--;
            outputText.add("Sorry, wrong guess. You have " + (chancesLeftToGuess) + " chances left. So far, you have");
            outputText.add( wordToGuess.displayString());

            if (chancesLeftToGuess == 0)
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
        List<String> retVal = new ArrayList<String>(outputText);
        outputText.clear();
        return retVal;
    }

    public List<Character> getGuessedLetters()
    {
        return new ArrayList<Character>(guessedLetters);
    }

    public boolean hasEnded()
    {
        return wordToGuess.hasGuessedWord() || chancesLeftToGuess <= 0;
    }

}
