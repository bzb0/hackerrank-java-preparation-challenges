package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Loops2 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(bufferedReader.readLine().trim());
    for (int i = 0; i < q; i++) {
      String[] tokens = bufferedReader.readLine().trim().split("\\s");
      int a = Integer.parseInt(tokens[0]);
      int b = Integer.parseInt(tokens[1]);
      int n = Integer.parseInt(tokens[2]);
      for (int j = 1; j <= n; j++) {
        int result = a + IntStream.range(0, j).map(val -> (int) (Math.pow(2, val) * b)).sum();
        System.out.printf("%d ", result);
      }
      System.out.println();
    }
    bufferedReader.close();
  }
}
