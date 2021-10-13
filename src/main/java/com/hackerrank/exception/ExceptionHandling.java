package com.hackerrank.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandling {

  private static class MyCalculator {

    long power(int n, int p) throws Exception {
      if (n < 0 || p < 0) {
        throw new Exception("n or p should not be negative.");
      }
      if (n == 0 && p == 0) {
        throw new Exception("n and p should not be zero.");
      }
      return (long) Math.pow(n, p);
    }
  }

  public static final MyCalculator my_calculator = new MyCalculator();
  public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      String[] tokens = line.trim().split(" ");
      int n = Integer.parseInt(tokens[0]);
      int p = Integer.parseInt(tokens[1]);

      try {
        System.out.println(my_calculator.power(n, p));
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}