package com.williamfiset.algorithms.dp;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import com.williamfiset.algorithms.utils.TestUtils;
import java.util.*;
import org.junit.rules.ExpectedException;
import org.junit.*;
public class Knapsack01Test {
    @Test
    public void knapsack01InvalidInputTest1(){
        int capacity = 10;
        int[] V = {1, 4, 8};
        int[] W = {3, 3, 5, 6};
        try {
            int val = Knapsack_01.knapsack(capacity, W, V);

        } catch (IllegalArgumentException e) {

            assertThat(e).hasMessageThat().contains("Invalid input");
        }

    }
    @Test
    public void knapsack01InvalidInputTest2(){
        int capacity = -1;
        int[] V = {1, 4, 8, 3};
        int[] W = {3, 3, 5, 6};
        try {
            int val = Knapsack_01.knapsack(capacity, W, V);

        } catch (IllegalArgumentException e) {

            assertThat(e).hasMessageThat().contains("Invalid input");
        }

    }

}
