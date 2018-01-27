/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.model;

import java.util.List;

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

    @Deprecated
    public List<Character> getIncorrectLetters();

    @Deprecated
    public String getDisplayString();

    public void start(GameConfig userConfig);
}
