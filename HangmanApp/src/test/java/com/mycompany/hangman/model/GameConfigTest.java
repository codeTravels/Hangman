package com.mycompany.hangman.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author cory.bianchi
 */
public class GameConfigTest
{

    public GameConfigTest()
    {
    }

    /**
     * Test of equals method, of class GameConfig.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_Null()
    {
        GameConfig instance = new GameConfig();
        assertFalse(instance.equals(null));
    }

    /**
     * Test of equals method, of class GameConfig.
     */
    @Test
    public void testEquals_Reflexive()
    {
        GameConfig obj1 = new GameConfig();
        assertTrue(obj1.equals(obj1));
    }

    /**
     * Test of equals method, of class GameConfig.
     */
    @Test
    public void testEquals_Symmetric()
    {
        GameConfig obj1 = new GameConfig();
        GameConfig obj2 = new GameConfig();
        assertTrue(obj1.equals(obj2));
        assertTrue(obj2.equals(obj1));
    }

    /**
     * Test of equals method, of class GameConfig.
     */
    @Test
    public void testEquals_Transitive()
    {
        GameConfig obj1 = new GameConfig();
        GameConfig obj2 = new GameConfig();
        GameConfig obj3 = new GameConfig();
        assertTrue(obj1.equals(obj2));
        assertTrue(obj2.equals(obj3));
        assertTrue(obj1.equals(obj3));
    }

    /**
     * Test of hashCode method, of class GameConfig.
     */
    @Test
    public void testHashCode()
    {
        GameConfig obj1 = new GameConfig();
        GameConfig obj2 = new GameConfig();
        assertTrue(obj1.equals(obj2));
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

}
