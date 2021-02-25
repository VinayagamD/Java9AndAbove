package com.vinaylogics.designpattern.creational.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    @DisplayName("TO test singleton eager")
    public void testSingletonEager(){
//        SingletonEager eager = new SingletonEager();
        SingletonEager eager1 = SingletonEager.INSTANCE;
        SingletonEager eager2 = SingletonEager.INSTANCE;
        assertNotNull(eager1);
        assertNotNull(eager2);
        assertSame(eager1, eager2);
    }

    @Test
    @DisplayName("To Test Singleton lazy")
    public void testSingletonLazy(){
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        assertNotNull(singletonLazy1);
        assertNotNull(singletonLazy2);
        assertSame(singletonLazy1 , singletonLazy2);
    }

    @Test
    @DisplayName("To Test Singleton Thread Safe 1")
    public void testSingletonThreadSafe1(){
        SingletonThreadSafe1 safe1 = SingletonThreadSafe1.getInstance();
        SingletonThreadSafe1 safe2 = SingletonThreadSafe1.getInstance();
        assertNotNull(safe1);
        assertNotNull(safe2);
        assertSame(safe1 , safe2);
    }

    @Test
    @DisplayName("To Test Singleton Thread Safe 2")
    public void testSingletonThreadSafe2(){
        SingletonThreadSafe2 safe1 = SingletonThreadSafe2.getInstance();
        SingletonThreadSafe2 safe2 = SingletonThreadSafe2.getInstance();
        assertNotNull(safe1);
        assertNotNull(safe2);
        assertSame(safe1 , safe2);
    }

    @Test
    @DisplayName("To Test Singleton Thread Safe 3")
    public void testSingletonThreadSafe3(){
        SingletonThreadSafe3 safe1 = SingletonThreadSafe3.getInstance();
        SingletonThreadSafe3 safe2 = SingletonThreadSafe3.getInstance();
        assertNotNull(safe1);
        assertNotNull(safe2);
        assertSame(safe1 , safe2);
    }



}