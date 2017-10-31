package com.mycompany.hangman.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Cory
 */
public class WordTest
{

    public WordTest()
    {
    }

    /**
     * Test of initialize method, of class Word.
     */
    @Test
    public void testInitialize()
    {
    }

    /**
     * Test of guessedCorrectLetter method, of class Word.
     */
    @Test
    public void testGuessedCorrectLetter()
    {
    }

    /**
     * Test of hasLetter method, of class Word.
     */
    @Test
    public void testHasLetter_char()
    {
    }

    /**
     * Test of hasLetter method, of class Word.
     */
    @Test
    public void testHasLetter_char_List()
    {
    }

    /**
     * Test of displayString method, of class Word.
     */
    @Test
    public void testDisplayString()
    {
        Word word = new Word("bat");
        String expected = "_ _ _";
        String outputText = word.displayString();
        assertEquals(expected, outputText);
    }

        @Test
    public void testDisplayString_TwoWords()
    {
        Word word = new Word("one two");
        String expected = "_ _ _   _ _ _";
        String outputText = word.displayString();
        assertEquals(expected, outputText);
    }

    /**
     * Test of getLettersLeftToGuess method, of class Word.
     */
    @Test
    public void testGetLettersLeftToGuess()
    {
    }

    /**
     * Test of hasGuessedWord method, of class Word.
     */
    @Test
    public void testHasGuessedWord()
    {
    }

    /**
     * Test of toString method, of class Word.
     */
    @Test
    public void testToString()
    {
    }

}
