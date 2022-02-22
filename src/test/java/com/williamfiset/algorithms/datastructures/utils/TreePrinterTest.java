package com.williamfiset.algorithms.datastructures.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

public class TreePrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private boolean[] test;
    

    @Before
        public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @Test
    public void test() {
        test =new boolean [13];
        printDebugInfo();
    }

    private void printDebugInfo() {
        for(int i = 0; i < test.length; i++) {
          System.out.println(" " + test[i]);
        }
    
      }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
