package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputFormatting {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("================================");
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      String[] tokens = line.split("\\s");
      System.out.printf("%-15s%03d\n", tokens[0], Integer.parseInt(tokens[1]));
    }
    System.out.println("================================");
    bufferedReader.close();
  }
}
