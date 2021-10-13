package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java1DArray1 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    int[] a = new int[n];
    int j = 0;
    while (n-- > 0) {
      a[j++] = Integer.parseInt(bufferedReader.readLine().trim());
    }
    bufferedReader.close();

    // Prints each sequential element in array a
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }
}