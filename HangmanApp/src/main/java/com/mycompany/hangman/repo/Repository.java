package com.mycompany.hangman.repo;

/**
 *
 * @author Cory
 * @param <T>
 */
public interface Repository<T>
{

    /**
     * Gets object T from the repository using the class name
     *
     * @param classType
     * @return
     */
    T get(Class<?> classType);

    /**
     * Gets object T from the repository using name as a key
     *
     * @param key key to search for
     * @return object T mapped to key name
     */
    T get(String key);

    /**
     * Adds object T to the repository
     *
     * @param value
     */
    void add(T value);

    /**
     * Puts object T into the repository with the given key
     *
     * @param key
     * @param value
     */
    void put(String key, T value);
}
