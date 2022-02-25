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
  public static String getTreeDisplay(PrintableNode root) {

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
          line.add(null);
          next.add(null);
          next.add(null);
        } else {
          String aa = n.getText();
          line.add(aa);
          if (aa.length() > widest) widest = aa.length();

          next.add(n.getLeft());
          next.add(n.getRight());

          if (n.getLeft() != null) nn++;
          if (n.getRight() != null) nn++;
        }
      }

      if (widest % 2 == 1) widest++;

      lines.add(line);

      List<PrintableNode> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
    
    return createTreeString(lines, perpiece);
  }

  public static String createTreeString(List<List<String>> lines, int perpiece) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i);
      int hpw = (int) Math.floor(perpiece / 2f) - 1;
      if (i > 0) {
        for (int j = 0; j < line.size(); j++) {

          // split node
          char c = ' ';
          if (j % 2 == 1) {
            if (line.get(j - 1) != null) {
              c = (line.get(j) != null) ? '#' : '#';
            } else {
              if (j < line.size() && line.get(j) != null) c = '#';
            }
          }
          sb.append(c);

          // lines and spaces
          if (line.get(j) == null) {

            sb.append(addSpace(sb, perpiece));
          } else {
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
        if (f == null) f = "";
        int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
        int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

        sb.append(addSpace(sb, gap1));
        sb.append(f);

        sb.append(addSpace(sb, gap2));
      }
      sb.append('\n');

      perpiece /= 2;
    }
    return sb.toString();
  }

  /*Returns a stringbuilder with the correct amount of space to make the tree pretty*/
  public static StringBuilder addSpace(StringBuilder sb, int gap){
    for (int k = 0; k < gap; k++) {
      sb.append(' ');
    }
    return sb;
    
  }

}
