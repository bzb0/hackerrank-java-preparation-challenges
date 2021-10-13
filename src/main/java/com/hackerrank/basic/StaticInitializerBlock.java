package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaticInitializerBlock {

  private static final String ERROR_MESSAGE = "java.lang.Exception: Breadth and height must be positive";

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int b = Integer.parseInt(bufferedReader.readLine().trim());
    int h = Integer.parseInt(bufferedReader.readLine().trim());
    bufferedReader.close();

    if (b > 0 && h > 0) {
      System.out.printf("%d", b * h);
    } else {
      System.out.printf("%s", ERROR_MESSAGE);
    }
  }
}
