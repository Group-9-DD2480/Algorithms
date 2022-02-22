// Taken from @MightyPork at:
// https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
package com.williamfiset.algorithms.datastructures.utils;

import java.util.*;

public class TreePrinter {

  /** Node that can be printed */
  public interface PrintableNode {

    // Get left child
    public PrintableNode getLeft();

    // Get right child
    public PrintableNode getRight();

    // Get text to be printed
    public String getText();
  }

  // Print a binary tree.

  public static boolean[] getTreeDisplay(PrintableNode root, boolean[] coverage) {

    StringBuilder sb = new StringBuilder();
    List<List<String>> lines = new ArrayList<List<String>>();
    List<PrintableNode> level = new ArrayList<PrintableNode>();
    List<PrintableNode> next = new ArrayList<PrintableNode>();

    level.add(root);
    int nn = 1;
    int widest = 0;

    while (nn != 0) {
      nn = 0;
      List<String> line = new ArrayList<String>();
      for (PrintableNode n : level) {
        
        if (n == null) {
          coverage[0] = true;
          line.add(null);
          next.add(null);
          next.add(null);
        } else {
          coverage[1] = true;
          String aa = n.getText();
          line.add(aa);
          if (aa.length() > widest) {widest = aa.length(); coverage[2] = true;}

          next.add(n.getLeft());
          next.add(n.getRight());

          if (n.getLeft() != null) nn++; coverage[3] = true;
          if (n.getRight() != null) nn++; coverage[4] = true;
        }
      }

      if (widest % 2 == 1) widest++ ; coverage[5] = true;

      lines.add(line);

      List<PrintableNode> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i);
      int hpw = (int) Math.floor(perpiece / 2f) - 1;
      if (i > 0) {
        coverage[6] = true;
        for (int j = 0; j < line.size(); j++) {

          // split node
          char c = ' ';
          if (j % 2 == 1) {
            coverage[7] = true;
            if (line.get(j - 1) != null) {
              coverage[8] = true;
              c = (line.get(j) != null) ? '#' : '#';
            } else {
              coverage[9] = true;
              if (j < line.size() && line.get(j) != null) c = '#';
            }
          }
          sb.append(c);

          // lines and spaces
          if (line.get(j) == null) {
            coverage[10] = true;
            for (int k = 0; k < perpiece - 1; k++) {
              sb.append(' ');
            }
          } else {
            coverage[11] = true;
            for (int k = 0; k < hpw; k++) {
              sb.append(j % 2 == 0 ? " " : "#");
            }
            sb.append(j % 2 == 0 ? "#" : "#");
            for (int k = 0; k < hpw; k++) {
              sb.append(j % 2 == 0 ? "#" : " ");
            }
          }
        }
        sb.append('\n');
      }
      for (int j = 0; j < line.size(); j++) {
        String f = line.get(j);
        if (f == null) f = ""; coverage[12] = true;
        int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
        int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

        for (int k = 0; k < gap1; k++) {
          sb.append(' ');
        }
        sb.append(f);
        for (int k = 0; k < gap2; k++) {
          sb.append(' ');
        }
      }
      sb.append('\n');

      perpiece /= 2;
    }
    
    return coverage;
    
  }
  
}
