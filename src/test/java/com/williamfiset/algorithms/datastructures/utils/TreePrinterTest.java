package com.williamfiset.algorithms.datastructures.utils;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.williamfiset.algorithms.datastructures.balancedtree.AVLTreeRecursive;

import com.williamfiset.algorithms.datastructures.segmenttree.Node;
import com.williamfiset.algorithms.datastructures.utils.TreePrinter.PrintableNode;

import org.junit.*;



public class TreePrinterTest {
    private AVLTreeRecursive<Integer> tree;

    @Before
        public void setup() {
        tree = new AVLTreeRecursive<>();
    }
    
    //Input a Tree with only one node and
    //output : 1
    @Test
    public void simpleGraph() {
        tree.insert(1);
        String output = TreePrinter.getTreeDisplay(tree.root);
        Assert.assertEquals("1", output.toString().strip());
    }

    //Input: a binary tree with three nodes
    /*Output 2     
                #######  
                1     3
              */
    @Test
    public void TreeWithBraanches (){
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        String output = TreePrinter.getTreeDisplay(tree.root);
        Assert.assertEquals("2     "+ "\n" + "   #######  " + "\n" + "   1     3", output.toString().strip());
    }

}
