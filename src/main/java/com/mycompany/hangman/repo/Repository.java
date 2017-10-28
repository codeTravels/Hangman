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
    public T get(Class<?> classType);

    public T get(String name);

    public void add(T value);

    public void put(String name, T value);
}
