/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.repo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cory
 * @param <T>
 */
public abstract class AbstractRepository<T> implements Repository<T>
{
    private final Map<String, T> objectMap = new HashMap<>();

    public AbstractRepository()
    {

    }

    @Override
    public T get(Class<?> classType)
    {
        return get(classType.getName());
    }

    @Override
    public T get(String key)
    {
        return objectMap.get(key);
    }

    @Override
    public void add(T value)
    {
        put(value.getClass().getName(), value);
    }

    @Override
    public void put(String key, T value)
    {
        objectMap.put(key, value);
    }

}
