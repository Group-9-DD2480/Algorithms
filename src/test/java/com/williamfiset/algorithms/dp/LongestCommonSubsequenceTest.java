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
    public void lcsNull(){
        char[] A = {'A', 'B', 'C'};
        char[] B = {};

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }

    // Expected output is null, as input contains a null value.
    @Test
    public void lcsNullFromNullInput(){
        char[] A = {'A', 'B', 'C'};
        char[] B = null;

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }

}