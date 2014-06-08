/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman;

import java.util.*;

/**
 *
 * @author Cory
 */
public class Hangman implements Game
{

    private int chancesLeftToGuess = 6;
    private Scanner scan = new Scanner(System.in);
    private List<Character> guessedLetters = new ArrayList();
    private WordGenerator wordGenerator = new WordGenerator();
    private Word wordToGuess;

    public void start()
    {
        wordToGuess = new Word(wordGenerator.generateWord());

        //Stops when the word is guessed or ran out of chances
        while (!wordToGuess.hasGuessedWord() && chancesLeftToGuess > 0)
        {
            char guessedLetter = getNextGuess();
            checkGuessedLetter(guessedLetter);
            if (wordToGuess.hasGuessedWord())
            {
                //Prints out if the word is figured out
                System.out.println("Great, you have figured out the word! It is " + wordToGuess + ".");
            }
            else if (Word.hasLetter(guessedLetter, guessedLetters))
            {
                System.out.println("You already guessed the letter '" + guessedLetter + "'. So far you have ");
                wordToGuess.print();
            }
            else if (wordToGuess.hasLetter(guessedLetter))
            {
                System.out.println("Great guess you got one!");
                wordToGuess.print();
            }
            else
            {
                chancesLeftToGuess--;
                System.out.println("Sorry, wrong guess. You have " + (chancesLeftToGuess) + " chances left. So far, you have ");
                wordToGuess.print();

                if (chancesLeftToGuess == 0)
                {
                    System.out.println("You Lose. The word was " + wordToGuess);
                }
            }
            addGuessedLetterToList(guessedLetter);
        }
    }

    public void setWordToGuess(String word)
    {
//        this.wordToGuess = word;
    }

    public void stop()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void reset()
    {
        throw new UnsupportedOperationException("Not supported yet.");
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
            System.out.println("Please make a valid guess.");
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
}
