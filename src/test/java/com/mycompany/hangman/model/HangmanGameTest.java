/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

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
        DisplayedDrawing mock = mock(DisplayedDrawing.class);
        HangmanGame game = new HangmanGame(mock);
        OutputCatcher outputCatcher = new OutputCatcher();
        game.addPropertyChangeListener(outputCatcher);
        game.reset(new Word("bat"));

        assertTrue(outputCatcher.getOutput().isEmpty());
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('a');
        List<String> expected = new ArrayList<String>();
        expected.add("Great guess you got one!");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ a _", game.getDisplayString());

        game.processLetter('t');
        expected.clear();
        expected.add("Great guess you got one!");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ a t", game.getDisplayString());

        game.processLetter('b');
        expected.clear();
        expected.add("Great, you have figured out the word! It is bat.");
        assertThat(outputCatcher.getOutput(), is(expected));

        assertTrue(game.gameOver());

    }

    @Test
    public void testProcessLetter_Loses()
    {
        HangmanGame game = new HangmanGame(new TempInterfaceImpl(5));
        OutputCatcher outputCatcher = new OutputCatcher();
        game.addPropertyChangeListener(outputCatcher);
        game.reset(new Word("bat"));

        assertTrue(outputCatcher.getOutput().isEmpty());
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('z');
        List<String> expected = new ArrayList<String>();
        expected.add("Sorry, wrong guess.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('y');
        expected.clear();
        expected.add("Sorry, wrong guess.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('x');
        expected.clear();
        expected.add("Sorry, wrong guess.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('w');
        expected.clear();
        expected.add("Sorry, wrong guess.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('v');
        expected.clear();
        expected.add("Sorry, wrong guess.");
        expected.add("You Lose. The word was bat.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ _ _", game.getDisplayString());

        assertTrue(game.gameOver());

    }
    @Test
    public void testProcessLetter_repeatGuess()
    {
        HangmanGame game = new HangmanGame(new TempInterfaceImpl(5));
        OutputCatcher outputCatcher = new OutputCatcher();
        game.addPropertyChangeListener(outputCatcher);
        game.reset(new Word("bat"));

        assertTrue(outputCatcher.getOutput().isEmpty());
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('a');
        List<String> expected = new ArrayList<String>();
        expected.add("Great guess you got one!");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ a _", game.getDisplayString());

        game.processLetter('a');
        expected.clear();
        expected.add("You already guessed the letter 'a'.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ a _", game.getDisplayString());

        game.processLetter('z');
        expected.clear();
        expected.add("Sorry, wrong guess.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ a _", game.getDisplayString());

        game.processLetter('z');
        expected.clear();
        expected.add("You already guessed the letter 'z'.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ a _", game.getDisplayString());

        game.processLetter('y');
        expected.clear();
        expected.add("Sorry, wrong guess.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ a _", game.getDisplayString());

        assertFalse(game.gameOver());

    }


    /**
     * Test of getGuessedLetters method, of class HangmanGame.
     */
    @Test
    public void testGetGuessedLetters()
    {
        HangmanGame game = new HangmanGame(new TempInterfaceImpl(5));
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
        assertFalse(game.gameOver());
    }

    protected static class TempInterfaceImpl implements DisplayedDrawing
    {
        private int limit;
        private int numTrys;
        protected TempInterfaceImpl(int numTrys)
        {
            this.limit = numTrys;
        }
        public void showEnableNext()
        {
            numTrys++;
        }

        public boolean doneDrawing()
        {
            return numTrys >= limit;
        }

        public void reset()
        {

        }
    }
    protected static class OutputCatcher implements PropertyChangeListener
    {
        private List<String> output = new ArrayList<>();

        protected OutputCatcher()
        {
        }

        public Collection<String> getOutput()
        {
            Collection<String> retVal = new ArrayList<>(output);
            output.clear();
            return retVal;
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {
           if (evt.getPropertyName().equals(HangmanGame.OUT_TEXT))
            {
                for (Object object : ((Iterable)evt.getNewValue()))
                {
                    output.add(object.toString());
                }
            }
        }

    }
}

