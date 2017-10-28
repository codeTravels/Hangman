/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.repo;

/**
 *
 * @author Cory
 */
public interface Repository<T>
{
    /**
     * Gets object T from the repository using the class name
     * @param classType
     * @return
     */
    public T get(Class<?> classType);

    /**
     * Gets object T from the repository using name as a key
     * @param key key to search for
     * @return object T mapped to key name
     */
    public T get(String key);

    /**
     * Adds object T to the repository
     * @param value
     */
    public void add(T value);

    /**
     * Puts object T into the repository with the given key
     * @param key
     * @param value
     */
    public void put(String key, T value);
}
