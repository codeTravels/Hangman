/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.gui;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Cory
 */
public class MyDocumentFilter extends DocumentFilter
{
   @Override
   public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException
   {
       System.out.println("MyDocumentFilter insertString");
        if (isAllowed(offset, 0, string))
        {
            super.insertString(fb, offset, string, attr);
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
    {
        System.out.println("MyDocumentFilter replace");
        if (isAllowed(offset, length, text))
        {
            super.replace(fb, offset, length, text, attrs);
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("Need to choose a lowercase letter a-z");
        }
    }

   private boolean isAllowed(int offset, int length, String string)
    {
       boolean allowInsert = true;
       for (int i = 0; i < string.length(); i++)
       {
           if (!Character.isLetter(string.charAt(i)) || !Character.isLowerCase(string.charAt(i)))
           {
               allowInsert = false;
               break;
           }

       }
        int charactersLimit =1 ;
        allowInsert &= (offset - length + string.length()) <= charactersLimit;
        return allowInsert;
    }
}
