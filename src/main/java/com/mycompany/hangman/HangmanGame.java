/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman;

import com.mycompany.hangman.gui.GuessedLetterObserver;
import com.mycompany.hangman.gui.PrintArea;
import java.util.*;

/**
 *
 * @author Cory
 */
public class HangmanGame implements Game, InputListener
{

    private static final int CHANCES_TO_GUESS = 5;
    private int chancesLeftToGuess;
    private List<Character> guessedLetters = new ArrayList();
    private Word wordToGuess;
    private PrintArea printArea;
    private GuessedLetterObserver guessedLetterObserver;
    private GameObserver gameObserver;

    public void setGameObserver(GameObserver observer)
    {
        this.gameObserver = observer;
    }

    public void start()
    {
        reset();
        //Stops when the word is guessed or ran out of chances
    }
     public void stop()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void reset()
    {
        wordToGuess = new WordGenerator().generateWord();
        chancesLeftToGuess = CHANCES_TO_GUESS;
        guessedLetters = new ArrayList();
        guessedLetterObserver.updateGuessedLetters(guessedLetters);

        printArea.println(wordToGuess.displayString());
    }

    public boolean hasEnded()
    {
        return wordToGuess.hasGuessedWord() || chancesLeftToGuess <= 0;
    }

    private void processLetter(char guessedLetter)
    {
        checkGuessedLetter(guessedLetter);

        if (wordToGuess.hasGuessedWord())
        {
            //Prints out if the word is figured out
            printArea.println("Great, you have figured out the word! It is " + wordToGuess + ".");
        }
        else if (Word.hasLetter(guessedLetter, guessedLetters))
        {
            printArea.println("You already guessed the letter '" + guessedLetter + "'. So far you have");
            printArea.println( wordToGuess.displayString());
        }
        else if (wordToGuess.hasLetter(guessedLetter))
        {
            printArea.println("Great guess you got one!");
            printArea.println( wordToGuess.displayString());
        }
        else
        {
            chancesLeftToGuess--;
            printArea.println("Sorry, wrong guess. You have " + (chancesLeftToGuess) + " chances left. So far, you have");
            printArea.println( wordToGuess.displayString());

            if (chancesLeftToGuess == 0)
            {
                printArea.println("You Lose. The word was " + wordToGuess);
            }
        }
        addGuessedLetterToList(guessedLetter);

        guessedLetterObserver.updateGuessedLetters(guessedLetters);
    }

    public void setGuessedLetterObserver(GuessedLetterObserver guessedLetterObserver)
    {
        this.guessedLetterObserver = guessedLetterObserver;
    }

    public void setPrintArea(PrintArea area)
    {
        this.printArea = area;
    }

    /**
     * Check if new letter is correct
     *
     * @param guessedLetter letter that was guessed
     */
    protected void checkGuessedLetter(char guessedLetter)
    {
        if (!Word.hasLetter(guessedLetter, guessedLetters))
        {
            wordToGuess.guessedCorrectLetter(guessedLetter);
        }
    }

    /**
     * Add letter to list of guessed letters
     *
     * @param letter letter that was guessed
     */
    protected void addGuessedLetterToList(char letter)
    {
        guessedLetters.add(new Character(letter));
    }

    protected boolean isALetter(char character)
    {
        //return ((character - 'a' ) < 26) || ((character - 'A') < 26);
        return ('a' <= character) && (character <= 'z');
    }

    /**
     * Called when there is an input from the user. Notifies if the input is a
     * letter.
     *
     * @param inputChar
     */
    public void inputEvent(char inputChar)
    {
        if (isALetter(inputChar))
        {
            processLetter(inputChar);
            if (hasEnded())
            {
                this.gameObserver.onGameEnded();
            }
        }
        else
        {
            printArea.println("Please make a valid guess. Choose between a-z.");
        }
    }
}
