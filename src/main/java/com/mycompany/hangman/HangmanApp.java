package com.mycompany.hangman;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class HangmanApp {

    public static void main(String[] args)
    {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        int option = 1;
        Hangman hangman = new Hangman();
        while (option == 1)
        {
            hangman.start();
            System.out.println("Press 1 to play again or 0 to quit");
            option = input.nextInt();
        }
        System.out.println("Thanks for playing! Come back soon.");
    }
}
