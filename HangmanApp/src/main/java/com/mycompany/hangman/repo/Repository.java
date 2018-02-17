package com.mycompany.hangman.repo;

public interface Repository<T>
{

    /**
     * Gets object T from the repository using the class name.
     *
     * @param classType the class
     * @return object T mapped to the class
     */
    T get(Class<?> classType);

    /**
     * Gets object T from the repository using name as a key.
     *
     * @param key key to search for
     * @return object T mapped to key name
     */
    T get(String key);

    /**
     * Adds object T to the repository.
     *
     * @param value the object to store
     */
    void add(T value);

    /**
     * Puts object T into the repository with the given key.
     *
     * @param key   the string key
     * @param value the object to store
     */
    void put(String key, T value);
}
