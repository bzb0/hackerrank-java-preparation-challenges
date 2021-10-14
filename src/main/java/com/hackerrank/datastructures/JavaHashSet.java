package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class JavaHashSet {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bufferedReader.readLine().trim());
    String[] pair_left = new String[t];
    String[] pair_right = new String[t];

    for (int i = 0; i < t; i++) {
      String [] tokens = bufferedReader.readLine().trim().split(" ");
      pair_left[i] = tokens[0];
      pair_right[i] = tokens[1];
    }

    Set<String> pairs = new HashSet<>();
    for (int i = 0; i < t; i++) {
      pairs.add(pair_left[i] + " " + pair_right[i]);
      System.out.println(pairs.size());
    }
  }
}
