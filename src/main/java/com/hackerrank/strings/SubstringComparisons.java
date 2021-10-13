package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class SubstringComparisons {

  public static String getSmallestAndLargest(String s, int k) {
    TreeSet<String> substrings = new TreeSet<>();
    for (int i = 0; i <= s.length() - k; i++) {
      substrings.add(s.substring(i, i + k));
    }
    return substrings.first() + "\n" + substrings.last();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();
    int k = Integer.parseInt(bufferedReader.readLine().trim());
    bufferedReader.close();
    System.out.println(getSmallestAndLargest(s, k));
  }
}
