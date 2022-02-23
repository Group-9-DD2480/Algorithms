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
}
