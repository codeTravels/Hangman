package com.mycompany.hangman.model;

public interface HangmanGame extends Model, Resetable
{

    String CLEAR_IMAGE = "CLEAR_IMAGE";
    String CLEAR_OUT_TEXT = "CLEAR_OUT_TEXT";
    String GAME_CONFIG = "GAME_CONFIG";
    String GAME_OVER = "GAME_OVER";
    String INCORRECT_LETTER = "INCORRECT_LETTER";
    String OUT_TEXT = "OUT_TEXT";
    String WORD = "WORD";
    String WRONG_GUESS = "WRONG_GUESS";

    void processLetter(char guessedLetter);

    void start(GameConfig userConfig);
}
