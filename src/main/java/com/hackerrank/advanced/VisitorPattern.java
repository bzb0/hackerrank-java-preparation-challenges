package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitorPattern {

  private enum Color {
    RED, GREEN
  }

  private static abstract class Tree {

    private int value;
    private Color color;
    private int depth;
    private int id;

    public Tree(int value, Color color, int depth) {
      this.value = value;
      this.color = color;
      this.depth = depth;
    }

    public int getValue() {
      return value;
    }

    public Color getColor() {
      return color;
    }

    public int getDepth() {
      return depth;
    }

    public abstract void accept(TreeVis visitor);
  }

  private static class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
      super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
      visitor.visitNode(this);

      for (Tree child : children) {
        child.accept(visitor);
      }
    }

    public void addChild(Tree child) {
      children.add(child);
    }
  }

  private static class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
      super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
      visitor.visitLeaf(this);
    }

    @Override
    public String toString() {
      return super.toString();
    }
  }

  private static abstract class TreeVis {

    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

  }

  private static class SumInLeavesVisitor extends TreeVis {

    private int result = 0;

    public int getResult() {
      return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
      result += leaf.getValue();
    }
  }

  private static class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private final int modulo = 1000000007;

    public int getResult() {
      return (int) result;
    }

    public void visitNode(TreeNode node) {
      if (Color.RED.equals(node.getColor())) {
        result = (result * node.getValue()) % modulo;
      }
    }

    public void visitLeaf(TreeLeaf leaf) {
      if (Color.RED.equals(leaf.getColor())) {
        result = (result * leaf.getValue()) % modulo;
      }
    }
  }

  private static class FancyVisitor extends TreeVis {

    private int evenDepthSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
      return Math.abs(evenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
      if (node.getDepth() % 2 == 0) {
        evenDepthSum += node.getValue();
      }
    }

    public void visitLeaf(TreeLeaf leaf) {
      if (Color.GREEN.equals(leaf.getColor())) {
        greenLeavesSum += leaf.getValue();
      }
    }
  }

  public static Tree solve() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int nodesCount = Integer.parseInt(bufferedReader.readLine().trim());
    int[] values = Arrays.stream(bufferedReader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] colors = Arrays.stream(bufferedReader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

    Map<Integer, List<Integer>> edges = new HashMap<>();
    for (int i = 0; i < nodesCount - 1; i++) {
      String[] edge = bufferedReader.readLine().trim().split(" ");
      int source = Integer.parseInt(edge[0]) - 1;
      int target = Integer.parseInt(edge[1]) - 1;
      edges.computeIfAbsent(source, key -> new ArrayList<>()).add(target);
      edges.computeIfAbsent(target, key -> new ArrayList<>()).add(source);
    }
    int rootIndex = 0;
    TreeNode root = new TreeNode(values[rootIndex], 0 == colors[rootIndex] ? Color.RED : Color.GREEN, 0);

    Tree srcNode, trgtNode;
    Map<Integer, Tree> nodes = new HashMap<>();
    nodes.put(rootIndex, root);
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(rootIndex);
    while (!stack.isEmpty()) {
      int currentNodeIndex = stack.pop();
      srcNode = nodes.get(currentNodeIndex);
      for (Integer target : edges.get(currentNodeIndex)) {
        if (nodes.containsKey(target)) {
          continue;
        }
        trgtNode = nodes.containsKey(target) ? nodes.get(target) : edges.get(target).size() > 1 ?
            new TreeNode(values[target], 0 == colors[target] ? Color.RED : Color.GREEN, srcNode.getDepth() + 1)
            : new TreeLeaf(values[target], 0 == colors[target] ? Color.RED : Color.GREEN, srcNode.getDepth() + 1);
        if (srcNode instanceof TreeNode) {
          ((TreeNode) srcNode).addChild(trgtNode);
        }
        nodes.put(target, trgtNode);
        stack.push(target);
      }
    }
    bufferedReader.close();
    return root;
  }

  public static void main(String[] args) throws IOException {
    Tree root = solve();
    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
    ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
    FancyVisitor vis3 = new FancyVisitor();

    root.accept(vis1);
    root.accept(vis2);
    root.accept(vis3);

    int res1 = vis1.getResult();
    int res2 = vis2.getResult();
    int res3 = vis3.getResult();

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
  }
}
