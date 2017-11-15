package com.mycompany.hangman.model;

import org.junit.Test;

/**
 *
 * @author Cory
 */
public class WordGeneratorTest
{

    /**
     * Test of generateWord method, of class WordGenerator.
     */
    @Test
    public void testGenerateWord_OneWordLib()
    {
        WordGenerator wordGenerator = new WordGenerator("src/test/resources/oneWordTestLib.txt");
        for (int i = 0; i < 1000; i++)
        {
            wordGenerator.generateWord();
        }
    }

}
