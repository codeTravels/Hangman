/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Cory
 */
public class WordGenerator
{

    private static final String WORD_FILE = "wordLib.txt";

    public Word generateWord()
    {
        String retVal = findStringToUse();

        return new Word(retVal.toLowerCase());
    }

    private String findStringToUse()
    {
        File inputFile;
        String retVal = null;
        BufferedReader buffer;
        try
        {
            inputFile = new File(WORD_FILE);
            buffer = new BufferedReader(new FileReader(inputFile));
            int randomLine = new Random().nextInt(wordCount());

            // String a = br.readLine();
            for (int i = 0; i <= randomLine; i++)
            {
                retVal = buffer.readLine();
            }
            buffer.close();
        }
        catch (IOException e)
        {
            System.err.println("Unable to read from file");
        }
        return retVal;
    }

    private int wordCount()
    {
        File inputFile;
        //String word = null;
        BufferedReader buffer;
        int retVal = 1;
        try
        {
            inputFile = new File(WORD_FILE);
            buffer = new BufferedReader(new FileReader(inputFile));
            //word=br.readLine();
            while (buffer.readLine() != null)
            {
                // word = br.readLine();
                retVal++;
                //error Checking
                //System.out.println("count is "+cnt+" word is "+word);
                //
            }
            buffer.close();
        }
        catch (IOException e)
        {
            System.err.println("Unable to read from file");
        }

        return retVal;
    }
}
