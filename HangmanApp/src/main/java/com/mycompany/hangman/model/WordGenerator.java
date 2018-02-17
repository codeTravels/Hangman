package com.mycompany.hangman.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Cory
 */
public class WordGenerator implements WordGeneratorService
{

    private static final String WORD_FILE = "src/main/resources/wordLib.txt";
    private static final String ENCODING = "UTF-8";
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

        return new Word(retVal.toUpperCase());
    }

    private String findStringToUse()
    {
        String retVal = "";
        BufferedReader buffer;
        try
        {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(wordFile), ENCODING);
            buffer = new BufferedReader(isr);
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
            InputStreamReader isr = new InputStreamReader(new FileInputStream(wordFile), ENCODING);
            buffer = new BufferedReader(isr);
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
