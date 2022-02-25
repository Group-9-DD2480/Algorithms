/**
 * This file contains an implementation of finding the Longest Common Subsequence (LCS) between two
 * strings using dynamic programming.
 *
 * <p>Time Complexity: O(nm)
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 */
package com.williamfiset.algorithms.dp;

public class LongestCommonSubsequence {

  // Checks if input to lcs is invalid (empyt or null)
  private static boolean checkInvalid(char[] A, char[] B) {
    if (A == null || B == null || A.length == 0 || B.length == 0) return true;
    return false;
  }

  // Will create a table that moves through the sequences and updates the
  // number of matching elements.
  private static int[][] matchTable(char[] A, char[] B, int n, int m) {
    
    int[][] matches = new int[n + 1][m + 1];

    // Suppose A = a1a2..an-1an and B = b1b2..bn-1bn
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        // If ends match the LCS(a1a2..an-1an, b1b2..bn-1bn) = LCS(a1a2..an-1, b1b2..bn-1) + 1
        if (A[i - 1] == B[j - 1]) matches[i][j] = matches[i - 1][j - 1] + 1;

        // If the ends do not match the LCS of a1a2..an-1an and b1b2..bn-1bn is
        // max( LCS(a1a2..an-1, b1b2..bn-1bn), LCS(a1a2..an-1an, b1b2..bn-1) )
        else matches[i][j] = Math.max(matches[i - 1][j], matches[i][j - 1]);
      }
    }
    return matches;
  }

  // Backtrack to find a LCS. We search for the cells
  // where we included an element which are those with
  // matches[i][j] != matches[i-1][j] and matches[i][j] != matches[i][j-1])
  private static char[] fillLcsArray(int[][] matches, char[] A, int n, int m, int lcsLen) {
    char[] lcs = new char[lcsLen];
    int index = 0;
    
    int i = n, j = m;
    while (i >= 1 && j >= 1) {

      int curNrOfMatches = matches[i][j];

      // The order of these may output different LCSs
      while (i > 1 && matches[i - 1][j] == curNrOfMatches) i--;
      while (j > 1 && matches[i][j - 1] == curNrOfMatches) j--;

      // Make sure there is a match before adding
      if (curNrOfMatches > 0) lcs[lcsLen - index++ - 1] = A[i - 1]; // or B[j-1];

      i--;
      j--;
    }

    return lcs;
  }

  // Returns a non unique Longest Common Subsequence
  // between the strings str1 and str2 in O(nm)
  public static String lcs(char[] A, char[] B) {

    // Check for invalid input
    if (checkInvalid(A, B)) return null;
    
    final int n = A.length;
    final int m = B.length;

    // Create a table with last corner element being nr of matches, 
    // i.e. length of subsequence.
    int[][] matches = matchTable(A, B, n, m);

    // Based on the table, fill an array with the matching characters.
    int lcsLen = matches[n][m];
    char[] lcs = fillLcsArray(matches, A, n, m, lcsLen);

    return new String(lcs, 0, lcsLen);
  }

  public static void main(String[] args) {

    char[] A = {'A', 'X', 'B', 'C', 'Y'};
    char[] B = {'Z', 'A', 'Y', 'W', 'B', 'C'};
    System.out.println(lcs(A, B)); // ABC

    A = new char[] {'3', '9', '8', '3', '9', '7', '9', '7', '0'};
    B = new char[] {'3', '3', '9', '9', '9', '1', '7', '2', '0', '6'};
    System.out.println(lcs(A, B)); // 339970
  }
}
