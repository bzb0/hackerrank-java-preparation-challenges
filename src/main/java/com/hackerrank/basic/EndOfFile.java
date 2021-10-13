package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndOfFile {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    int lineCounter = 0;
    while ((line = bufferedReader.readLine()) != null) {
      System.out.printf("%d %s\n", ++lineCounter, line);
    }
  }
}
