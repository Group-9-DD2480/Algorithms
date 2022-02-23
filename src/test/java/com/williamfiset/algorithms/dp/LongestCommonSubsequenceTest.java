package com.williamfiset.algorithms.dp;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonSubsequenceTest {

    @Test
    public void lcsCorrect() {
        char[] A = {'A', 'B', 'C', 'D', 'E'};
        char[] B = {'X', 'Y', 'C', 'D', 'Z'};

        String expected = "CD";
        String actual = LongestCommonSubsequence.lcs(A, B);

        assertEquals(expected, actual);
    }

    @Test
    public void lcsNull(){
        char[] A = {'A', 'B', 'C'};
        char[] B = {};

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }

    @Test
    public void lcsNullFromNullInput(){
        char[] A = {'A', 'B', 'C'};
        char[] B = null;

        String result = LongestCommonSubsequence.lcs(A, B);
        assertNull(result);
    }

}