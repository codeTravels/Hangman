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
public class WordGenerator implements WordGeneratorService
{

    private static final String WORD_FILE = "src/main/resources/wordLib.txt";
    private final File wordFile;

    public WordGenerator()
    {
        this(WORD_FILE);
    }

    protected WordGenerator(String wordFilePath)
    {
        this.wordFile = new File(wordFilePath);
    }

    @Override
    public Word generateWord()
    {
        String retVal = findStringToUse();

        return new Word(retVal.toLowerCase());
    }

    private String findStringToUse()
    {
        String retVal = "";
        BufferedReader buffer;
        try
        {
            buffer = new BufferedReader(new FileReader(wordFile));
            int randomLine = new Random().nextInt(wordCount());

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
        BufferedReader buffer;
        int retVal = 0;
        try
        {
            buffer = new BufferedReader(new FileReader(wordFile));
            while (buffer.readLine() != null)
            {
                retVal++;
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
