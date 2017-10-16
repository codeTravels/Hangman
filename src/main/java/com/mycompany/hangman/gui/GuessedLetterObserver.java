/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.gui;

import java.util.List;
import com.mycompany.hangman.Character;

/**
 *
 * @author Cory
 */
public interface GuessedLetterObserver
{
    public void updateGuessedLetters (List<Character> guessedLetters);
}
