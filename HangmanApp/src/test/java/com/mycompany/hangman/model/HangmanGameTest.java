package com.mycompany.hangman.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Cory
 */
public class HangmanGameTest
{
    @Rule
    public final TestRule watcher = new TestWatcher()
    {
        @Override
        protected void starting(Description description)
        {
            System.out.println("Staring test: " + description);
        }
    };

    public HangmanGameTest()
    {
    }

        private WordGeneratorService createWordService(Word word)
    {
        WordGeneratorService wordGenSvc = mock(WordGeneratorService.class);
        when(wordGenSvc.generateWord()).thenReturn(word);
        return wordGenSvc;
    }

    /**
     * Test of reset method, of class HangmanGame.
     */
    @Test
    public void testReset()
    {
        WordGeneratorService wordGenSvc = createWordService(new Word("bat"));
        HangmanGame game = new HangmanGame(wordGenSvc);

        final Map<String, Object> actual = new HashMap<>();
        game.addPropertyChangeListener((PropertyChangeEvent evt) ->
        {
            actual.put(evt.getPropertyName(), evt.getNewValue());
        });
        game.reset();

        Map<String, Object> expected = new HashMap<>();
        expected.put(HangmanGame.WORD, "_ _ _");
        expected.put(HangmanGame.CLEAR_IMAGE, true);
        expected.put(HangmanGame.INCORRECT_LETTER, new ArrayList<>());
        expected.put(HangmanGame.CLEAR_OUT_TEXT, true);
        assertEquals(expected, actual);
    }

    /**
     * Test of isGameOver method, of class HangmanGame.
     */
    @Test
    public void testIsGameOver_NoMoreGuesses()
    {
        WordGeneratorService wordGenSvc = createWordService(new Word("bat"));
        HangmanGame game = new HangmanGame(wordGenSvc);
        GameConfig config = new GameConfig();
        config.setNumGuessesAllowed(1);
        game.setConfig(config);
        assertFalse(game.isGameOver());
        game.processLetter('z');
        assertTrue(game.isGameOver());
    }
    /**
     * Test of isGameOver method, of class HangmanGame.
     */
    @Test
    public void testIsGameOver_GuessedWord()
    {
        WordGeneratorService wordGenSvc = createWordService(new Word("bat"));
        HangmanGame game = new HangmanGame(wordGenSvc);
        assertFalse(game.isGameOver());
        game.processLetter('b');
        assertFalse(game.isGameOver());
        game.processLetter('a');
        assertFalse(game.isGameOver());
        game.processLetter('t');
        assertTrue(game.isGameOver());
    }

    /**
     * Test of processLetter method, of class HangmanGame.
     */
    @Test
    public void testProcessLetter_wins()
    {
        WordGeneratorService wordGenSvc = createWordService(new Word("bat"));
        HangmanGame game = new HangmanGame(wordGenSvc);
        OutputCatcher outputCatcher = new OutputCatcher();
        game.addPropertyChangeListener(outputCatcher);

        assertTrue(outputCatcher.getOutput().isEmpty());
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('a');
        List<String> expected = new ArrayList<>();
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

        assertTrue(game.isGameOver());

    }

    @Test
    public void testProcessLetter_Loses()
    {
        WordGeneratorService wordGenSvc = createWordService(new Word("bat"));
        HangmanGame game = new HangmanGame(wordGenSvc);
        OutputCatcher outputCatcher = new OutputCatcher();
        game.addPropertyChangeListener(outputCatcher);

        assertTrue(outputCatcher.getOutput().isEmpty());
        assertEquals("_ _ _", game.getDisplayString());

        List<Character> guessList = new ArrayList<>();
        guessList.add(new Character('z'));
        guessList.add(new Character('y'));
        guessList.add(new Character('x'));
        guessList.add(new Character('w'));
        guessList.add(new Character('v'));

        List<String> expected = new ArrayList<>();
        for (Character character : guessList)
        {
            game.processLetter(character.get());
            expected.clear();
            expected.add("Sorry, wrong guess.");
            assertThat(outputCatcher.getOutput(), is(expected));
            assertEquals("_ _ _", game.getDisplayString());
        }

        game.processLetter('u');
        expected.clear();
        expected.add("Sorry, wrong guess.");
        expected.add("You Lose. The word was bat.");
        assertThat(outputCatcher.getOutput(), is(expected));
        assertEquals("_ _ _", game.getDisplayString());

        assertTrue(game.isGameOver());

    }
    @Test
    public void testProcessLetter_repeatGuess()
    {
        WordGeneratorService wordGenSvc = createWordService(new Word("bat"));
        HangmanGame game = new HangmanGame(wordGenSvc);
        OutputCatcher outputCatcher = new OutputCatcher();
        game.addPropertyChangeListener(outputCatcher);

        assertTrue(outputCatcher.getOutput().isEmpty());
        assertEquals("_ _ _", game.getDisplayString());

        game.processLetter('a');
        List<String> expected = new ArrayList<>();
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

        assertFalse(game.isGameOver());

    }


    /**
     * Test of getGuessedLetters method, of class HangmanGame.
     */
    @Test
    public void testGetGuessedLetters()
    {
        WordGeneratorService wordGenSvc = createWordService(new Word("bat"));
        HangmanGame game = new HangmanGame(wordGenSvc);
        String input = "zxtza";
        for (int i = 0; i < input.length(); i++)
        {
            game.processLetter(input.charAt(i));
        }
        assertEquals(2, game.getIncorrectLetters().size());
        assertEquals('z', game.getIncorrectLetters().get(0).get());
        assertEquals('x', game.getIncorrectLetters().get(1).get());
        assertFalse(game.isGameOver());
    }

    protected static class OutputCatcher implements PropertyChangeListener
    {
        private final List<String> output = new ArrayList<>();

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

