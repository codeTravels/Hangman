/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cory
 */
public class HangmanGameTest
{

    public HangmanGameTest()
    {
    }

    /**
     * Test of reset method, of class HangmanGame.
     */
    @Test
    public void testReset()
    {
    }

    /**
     * Test of hasEnded method, of class HangmanGame.
     */
    @Test
    public void testHasEnded()
    {
    }

    /**
     * Test of processLetter method, of class HangmanGame.
     */
    @Test
    public void testProcessLetter_wins()
    {
        HangmanGame game = new HangmanGame();
        game.reset(new Word("bat"));

        List<String> expected = new ArrayList<String>();
        expected.add("_ _ _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('a');
        expected.clear();
        expected.add("Great guess you got one!");
        expected.add("_ a _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('t');
        expected.clear();
        expected.add("Great guess you got one!");
        expected.add("_ a t");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('b');
        expected.clear();
        expected.add("Great, you have figured out the word! It is bat.");
        assertThat(game.getOutputText(), is(expected));

        assertTrue(game.hasEnded());

    }

    @Test
    public void testProcessLetter_Loses()
    {
        HangmanGame game = new HangmanGame();
        game.reset(new Word("bat"));
        int expectedChances = HangmanGame.CHANCES_TO_GUESS;

        List<String> expected = new ArrayList<String>();
        expected.add("_ _ _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('z');
        expected.clear();
        expected.add("Sorry, wrong guess. You have "+(--expectedChances)+" chances left. So far, you have");
        expected.add("_ _ _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('y');
        expected.clear();
        expected.add("Sorry, wrong guess. You have "+(--expectedChances)+" chances left. So far, you have");
        expected.add("_ _ _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('x');
        expected.clear();
        expected.add("Sorry, wrong guess. You have "+(--expectedChances)+" chances left. So far, you have");
        expected.add("_ _ _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('w');
        expected.clear();
        expected.add("Sorry, wrong guess. You have "+(--expectedChances)+" chances left. So far, you have");
        expected.add("_ _ _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('v');
        expected.clear();
        expected.add("Sorry, wrong guess. You have "+(--expectedChances)+" chances left. So far, you have");
        expected.add("_ _ _");
        expected.add("You Lose. The word was bat.");
        assertThat(game.getOutputText(), is(expected));

        assertTrue(game.hasEnded());

    }
    @Test
    public void testProcessLetter_repeatGuess()
    {
        HangmanGame game = new HangmanGame();
        game.reset(new Word("bat"));
        int expectedChances = HangmanGame.CHANCES_TO_GUESS;

        List<String> expected = new ArrayList<String>();
        expected.add("_ _ _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('a');
        expected.clear();
        expected.add("Great guess you got one!");
        expected.add("_ a _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('a');
        expected.clear();
        expected.add("You already guessed the letter 'a'. So far you have");
        expected.add("_ a _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('z');
        expected.clear();
        expected.add("Sorry, wrong guess. You have "+(--expectedChances)+" chances left. So far, you have");
        expected.add("_ a _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('z');
        expected.clear();
        expected.add("You already guessed the letter 'z'. So far you have");
        expected.add("_ a _");
        assertThat(game.getOutputText(), is(expected));

        game.processLetter('y');
        expected.clear();
        expected.add("Sorry, wrong guess. You have "+(--expectedChances)+" chances left. So far, you have");
        expected.add("_ a _");
        assertThat(game.getOutputText(), is(expected));

        assertFalse(game.hasEnded());

    }


    /**
     * Test of getGuessedLetters method, of class HangmanGame.
     */
    @Test
    public void testGetGuessedLetters()
    {
        HangmanGame game = new HangmanGame();
        game.reset(new Word("bat"));
        String input = "zxtza";
        for (int i = 0; i < input.length(); i++)
        {
            game.processLetter(input.charAt(i));

            String substring = input.substring(0, (i+1)); // grab all the letters used for input up to this time
            List<Character> guessedLetters = game.getGuessedLetters();
            assertEquals(substring.length(),guessedLetters.size());

            for (int j = 0; j < substring.length(); j++)
            {
                assertEquals(substring.charAt(j),guessedLetters.get(j).get()); // verify all the letters of input are accounted for in order
            }
        }
        assertFalse(game.hasEnded());
    }

}
