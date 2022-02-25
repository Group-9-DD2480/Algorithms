package com.williamfiset.algorithms.dp;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import com.williamfiset.algorithms.utils.TestUtils;
import java.util.*;
import org.junit.rules.ExpectedException;
import org.junit.*;
public class Knapsack01Test {
    @Test(expected = IllegalArgumentException.class)
    public void knapsack01InvalidInputTest1() {
        int capacity = 10;
        int[] V = {1, 4, 8};
        int[] W = {3, 3, 5, 6};
        int val = Knapsack_01.knapsack(capacity, W, V);

    }
    /*Input:V = {1, 4, 8, 3}, W = {3, 3, 5, 6}, capacity = -1
     Valid weight and value array, but negative capacity.
    * Output: Throw IllegalArgumentException
    */
    @Test(expected = IllegalArgumentException.class)
    public void knapsack01InvalidInputTest2() {
        int capacity = -1;
        int[] V = {1, 4, 8, 3};
        int[] W = {3, 3, 5, 6};
        int val = Knapsack_01.knapsack(capacity, W, V);

    }
    /*Input: V = null, W = {3, 3, 5, 6}, capacity = 10
     Valid weight and capacity, but null value array.
     * Output: Throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void knapsack01InvalidInputTest3() {
        int capacity = 10;
        int[] V = null;
        int[] W = {3, 3, 5, 6};
        int val = Knapsack_01.knapsack(capacity, W, V);

    }
    /*Input: V = {1, 4, 8, 3}, W = {3, 3, 5, 6}, capacity = 10
    Output: 12.
    */
    @Test
    public void knapsack01CorrectOutputTest() {
        int capacity = 10;
        int[] V = {1, 4, 8, 3};
        int[] W = {3, 3, 5, 6};
        int val = Knapsack_01.knapsack(capacity, W, V);
        assertThat(val).isEqualTo(12);

    }

}
