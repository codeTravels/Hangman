package com.mycompany.hangman.model;

/**
 *
 * @author Cory
 */
public interface HangmanGame extends Model, Resetable
{

    public final static String CLEAR_IMAGE = "CLEAR_IMAGE";
    public final static String CLEAR_OUT_TEXT = "CLEAR_OUT_TEXT";
    public final static String GAME_CONFIG = "GAME_CONFIG";
    public final static String GAME_OVER = "GAME_OVER";
    public final static String INCORRECT_LETTER = "INCORRECT_LETTER";
    public final static String OUT_TEXT = "OUT_TEXT";
    public final static String WORD = "WORD";
    public final static String WRONG_GUESS = "WRONG_GUESS";

    public void processLetter(char guessedLetter);

    public void start(GameConfig userConfig);
}
