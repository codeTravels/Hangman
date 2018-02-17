package com.mycompany.hangman.repo;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<T> implements Repository<T>
{

    private final Map<String, T> objectMap = new HashMap<>();

    public InMemoryRepository()
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
