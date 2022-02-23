package com.williamfiset.algorithms.datastructures.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.williamfiset.algorithms.datastructures.balancedtree.AVLTreeRecursive;

import org.junit.*;

public class TreePrinterTest {

    private boolean[] test;
    private AVLTreeRecursive<Integer> tree;
    

    @Before
        public void setup() {
        tree = new AVLTreeRecursive<>();
    }
    
    @Test
    public void test() {
        test =new boolean [13];
        for(int i = 0; i < test.length; i++) {
            System.out.println(i + " : " + test[i]);
          }
    }

}
