package com.mycompany.hangman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cory
 */
public class HangmanGameImpl extends AbstractModel implements HangmanGame
{

    private GameConfig config = new GameConfig();
    private int chancesLeftToGuess;
    private final List<Character> incorrectLetters = new ArrayList();
    private Word wordToGuess;
    private final WordGeneratorService wordGenerator;

    public HangmanGameImpl(WordGeneratorService wordGenerator)
    {
        this.wordGenerator = wordGenerator;
        reset();
    }

    @Override
    public final void reset()
    {
        wordToGuess = wordGenerator.generateWord();
        firePropertyChange(WORD, null, wordToGuess.displayString());
        chancesLeftToGuess = config.getNumGuessesAllowed();
        firePropertyChange(CLEAR_IMAGE, false, true);
        incorrectLetters.clear();
        firePropertyChange(INCORRECT_LETTER, null, getIncorrectLetters());
        firePropertyChange(CLEAR_OUT_TEXT, false, true);
    }

    @Override
    public void processLetter(char guessedLetter)
    {
        Collection<String> outputText = new LinkedList<>();
        boolean alreadyDisplayed = wordToGuess.isDisplaying(guessedLetter);
        wordToGuess.guessedCorrectLetter(guessedLetter);
        firePropertyChange(WORD, null, wordToGuess.displayString());

        if (wordToGuess.hasGuessedWord())
        {
            outputText.add("Great, you have figured out the word! It is " + wordToGuess + ".");
        }
        else if (Word.hasLetter(guessedLetter, incorrectLetters) || alreadyDisplayed)
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
            addToIncorrectLetters(guessedLetter);
            firePropertyChange(WRONG_GUESS, false, true);
            outputText.add("Sorry, wrong guess.");

            if (chancesLeftToGuess == 0)
            {
                outputText.add("You Lose. The word was " + wordToGuess + ".");
            }
        }
        firePropertyChange(OUT_TEXT, null, outputText);
        firePropertyChange(GAME_OVER, false, isGameOver());

    }

    /**
     * Add letter to list of guessed letters
     *
     * @param letter letter that was guessed
     */
    private void addToIncorrectLetters(char letter)
    {
        List<Character> oldValue = getIncorrectLetters();
        incorrectLetters.add(new Character(letter));
        firePropertyChange(INCORRECT_LETTER, oldValue, getIncorrectLetters());
    }

    @Override
    public List<Character> getIncorrectLetters()
    {
        return new ArrayList<>(incorrectLetters);
    }

    @Override
    public String getDisplayString()
    {
        return wordToGuess.displayString();
    }

    public boolean isGameOver()
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
