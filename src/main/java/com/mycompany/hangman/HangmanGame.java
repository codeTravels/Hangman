/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman;

import com.mycompany.hangman.gui.PrintArea;
import java.util.*;

/**
 *
 * @author Cory
 */
public class HangmanGame implements Game, InputListener
{

    private static int CHANCES_TO_GUESS = 5;
    private int chancesLeftToGuess;
    private Scanner scan = new Scanner(System.in);
    private List<Character> guessedLetters = new ArrayList();
    private char guessedLetter;
    private WordGenerator wordGenerator = new WordGenerator();
    private Word wordToGuess;
    private PrintArea printArea;
    private final Object lock = new Object();

    public void start()
    {
        reset();
        //Stops when the word is guessed or ran out of chances
        while (!wordToGuess.hasGuessedWord() && chancesLeftToGuess > 0)
        {
            guessedLetter = getNextGuess();
            checkGuessedLetter(guessedLetter);
            
            if (wordToGuess.hasGuessedWord())
            {
                //Prints out if the word is figured out
                printArea.println("Great, you have figured out the word! It is " + wordToGuess + ".");
            }
            else if (Word.hasLetter(guessedLetter, guessedLetters))
            {
                printArea.println("You already guessed the letter '" + guessedLetter + "'. So far you have ");
                wordToGuess.print();
            }
            else if (wordToGuess.hasLetter(guessedLetter))
            {
                printArea.println("Great guess you got one!");
                wordToGuess.print();
            }
            else
            {
                chancesLeftToGuess--;
                printArea.println("Sorry, wrong guess. You have " + (chancesLeftToGuess) + " chances left. So far, you have ");
                wordToGuess.print();

                if (chancesLeftToGuess == 0)
                {
                    printArea.println("You Lose. The word was " + wordToGuess);
                }
            }
            addGuessedLetterToList(guessedLetter);
        }
    }

    public void setWordToGuess(String word)
    {
//        this.wordToGuess = word;
    }

    public void setPrintArea(PrintArea area)
    {
        this.printArea = area;
    }
    public void stop()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void reset()
    {
        wordToGuess = new Word(wordGenerator.generateWord());
        wordToGuess.setPrintArea(printArea);
        chancesLeftToGuess = CHANCES_TO_GUESS;
        guessedLetters = new ArrayList();
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

    /**
     * Gets a char that is from 'a' to 'z' from user input
     *
     * @return
     */
    protected char getNextGuess()
    {
        char retVal;
        do
        {
            printArea.println("Please make a valid guess.");
            retVal = scan.nextLine().charAt(0);
        }
        while (!isALetter(retVal));
        return retVal;
    }

    protected boolean isALetter(char character)
    {
        //return ((character - 'a' ) < 26) || ((character - 'A') < 26);
        return ('a' <= character) && (character <= 'z');
    }

    public void inputEvent(char inputChar)
    {
        if (isALetter(inputChar))
        {
            guessedLetter = inputChar;
        }
    }
}
