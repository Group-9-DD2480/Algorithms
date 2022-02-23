package com.williamfiset.algorithms.math;
import static org.junit.Assert.*;

import org.junit.*;
public class IsPrimeTest {
    //Input: a prime number
    //expected output: true
    @Test
    public void testIsPrimetrue(){
        boolean result = IsPrime.isPrime(5);
        assertTrue(result);
    }

    //Input: a non prime number
    //expected output: false
    @Test
    public void testIsPrimeFalse(){
        boolean result = IsPrime.isPrime(9);
        assertFalse(result);
    }

    //Input: 1
    //expected output: false
    @Test
    public void testIsPrime1(){
        boolean result = IsPrime.isPrime(1);
        assertFalse(result);
    }

    //Input: 2
    //expected output: true
    @Test
    public void testIsPrime2(){
        boolean result = IsPrime.isPrime(2);
        assertTrue(result);
    }

    //Input: 4
    //expected output: false
    @Test
    public void testIsPrime4(){
        boolean result = IsPrime.isPrime(4);
        assertFalse(result);
    }
}
