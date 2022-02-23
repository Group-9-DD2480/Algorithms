package com.williamfiset.algorithms.datastructures.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.williamfiset.algorithms.datastructures.balancedtree.AVLTreeRecursive;

import org.junit.*;

public class TreePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private boolean[] test;
    private AVLTreeRecursive<Integer> tree;
    

    @Before
        public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        tree = new AVLTreeRecursive<>();
    }
    
    @Test
    public void test() {
        test =new boolean [13];
        test = TreePrinter.getTreeDisplay(tree.root, test);
        for(int i = 0; i < test.length; i++) {
            System.out.println(i + " : " + test[i]);
          }
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
