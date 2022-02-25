package com.williamfiset.algorithms.dp;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import com.williamfiset.algorithms.utils.TestUtils;
import java.util.*;
import org.junit.rules.ExpectedException;
import org.junit.*;
public class Knapsack01Test {
    public Knapsack_01 obj = new Knapsack_01();
    @Test(expected = IllegalArgumentException.class)
    public void knapsack01InvalidInputTest1() {
        int capacity = 10;
        int[] V = {1, 4, 8};
        int[] W = {3, 3, 5, 6};
        int val = obj.knapsack(capacity, W, V);

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
        int val = obj.knapsack(capacity, W, V);

    }

    /*Input: V = null, W = {3, 3, 5, 6}, capacity = 10
     Valid weight and capacity, but null value array.
     Output: Throw IllegalArgumentException
     */

    @Test(expected = IllegalArgumentException.class)
    public void knapsack01InvalidInputTest3() {
        int capacity = 10;
        int[] V = null;
        int[] W = {3, 3, 5, 6};
        int val = obj.knapsack(capacity, W, V);
        //cov3 = Knapsack_01.branch_coverage;

    }


    /*Input: V = {1, 4, 8, 3}, W = {3, 3, 5, 6}, capacity = 10
    Output: 12.
    */
    @Test
    public void knapsack01CorrectOutputTest() {
        int capacity = 10;
        int[] V = {1, 4, 8, 3};
        int[] W = {3, 3, 5, 6};
        int val = obj.knapsack(capacity, W, V);
        assertThat(val).isEqualTo(12);

    }

    @Test
    public void runBranchCoverage(){
        boolean[] coverage = new boolean[10];
        //from correct output test
        int capacity = 10;
        int[] V = {1, 4, 8, 3};
        int[] W = {3, 3, 5, 6};
        int val = obj.knapsack(capacity, W, V);

        for(int i = 0; i < coverage.length; i++){
            if(obj.branch_coverage[i]) coverage[i] = true;
        }

        //From invalid input test 1
        int[] V_2 = {1, 4, 8};
        try {
            val = obj.knapsack(capacity, W, V_2);
        }catch(IllegalArgumentException e){}
        for(int i = 0; i < coverage.length; i++){
            if(obj.branch_coverage[i]) coverage[i] = true;
        }
        //from invalid input test 2
        capacity = -1;
        try {
            val = obj.knapsack(capacity, W, V);
        }catch(IllegalArgumentException e){}
        for(int i = 0; i < coverage.length; i++){
            if(obj.branch_coverage[i]) coverage[i] = true;
        }
        capacity = 10;
        V = null;
        try {
            val = obj.knapsack(capacity, W, V);
        }catch(IllegalArgumentException e){}
        for(int i = 0; i < coverage.length; i++){
            if(obj.branch_coverage[i]) coverage[i] = true;
        }

        for(int i = 0; i < coverage.length; i++){
            System.out.println(coverage[i]);
        }


    }




}
