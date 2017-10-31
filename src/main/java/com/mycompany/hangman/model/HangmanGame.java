package com.mycompany.hangman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cory
 */
public class HangmanGame extends AbstractModel
{
    public final static String CLEAR_IMAGE = "CLEAR_IMAGE";
    public final static String CLEAR_OUT_TEXT = "CLEAR_OUT_TEXT";
    public final static String GAME_CONFIG = "GAME_CONFIG";
    public final static String GAME_OVER = "GAME_OVER";
    public final static String GUESSED_LETTER = "GUESSED_LETTER";
    public final static String OUT_TEXT = "OUT_TEXT";
    public final static String WORD = "WORD";
    public final static String WRONG_GUESS = "WRONG_GUESS";

    private GameConfig config = new GameConfig();
    private int chancesLeftToGuess;
    private final List<Character> guessedLetters = new ArrayList();
    private Word wordToGuess;
    private final WordGeneratorService wordGenerator;

    public HangmanGame(WordGeneratorService wordGenerator)
    {
        this.wordGenerator = wordGenerator;
        reset();
    }

    public final void reset()
    {
        wordToGuess = wordGenerator.generateWord();
        firePropertyChange(WORD, null, wordToGuess.displayString() );
        chancesLeftToGuess = config.getNumGuessesAllowed();
        firePropertyChange(CLEAR_IMAGE, false, true);
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
            chancesLeftToGuess--;
            firePropertyChange(WRONG_GUESS, false, true);
            outputText.add("Sorry, wrong guess.");

            if (chancesLeftToGuess == 0)
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
        return wordToGuess.hasGuessedWord() || chancesLeftToGuess <= 0;
    }

    public void setConfig(GameConfig config)
    {
        GameConfig oldValue = this.config;
        this.config = config;
        firePropertyChange(GAME_CONFIG, oldValue, this.config);
        reset();
    }

}
