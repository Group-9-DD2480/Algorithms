package com.williamfiset.algorithms.dp;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonSubsequenceTest {

    // Correct implementation, expected output is the same as actual.
    @Test
    public void lcsCorrect() {
        char[] A = {'A', 'B', 'C', 'D', 'E'};
        char[] B = {'X', 'Y', 'C', 'D', 'Z'};

        String expected = "CD";
        String actual = LongestCommonSubsequence.lcs(A, B);

        assertEquals(expected, actual);
    }
    
    // Expected output is an empty string.
    @Test
    public void lcsCorrectNoMatch() {
        char[] A = {'A', 'B', 'C'};
        char[] B = {'X', 'Y', 'Z'};

        String expected = "";
        String actual = LongestCommonSubsequence.lcs(A,B);

        assertEquals(expected, actual);
    }

    // Expected output is null, as input contains an empty array.
    @Test
    public void lcsNullEmptyA(){
        char[] A = {};
        char[] B = {'A', 'B', 'C'};

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }

    // Expected output is null, as input contains an empty array.
    @Test
    public void lcsNullEmptyB(){
        char[] A = {'A', 'B', 'C'};
        char[] B = {};

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }

    // Expected output is null, as input contains a null value.
    @Test
    public void lcsNullFromNullA(){
        char[] A = null;
        char[] B = {'A', 'B', 'C'};

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }

    // Expected output is null, as input contains a null value.
    @Test
    public void lcsNullFromNullB(){
        char[] A = {'A', 'B', 'C'};
        char[] B = null;

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }
    @Test
    public void branchCoverageTest() {
        lcsCorrect();
        lcsCorrectNoMatch();
        lcsNullEmptyA();
        lcsNullEmptyB();
        lcsNullFromNullA();
        lcsNullFromNullB();

        boolean[] expected = new boolean[14];
        for (int i = 0; i < 14; i++) expected[i] = true;
        boolean[] actual = LongestCommonSubsequence.activated;
        assertArrayEquals(expected, actual);
    }
}