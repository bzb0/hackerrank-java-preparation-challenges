package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdinAndStdout2 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int intNumber = Integer.parseInt(bufferedReader.readLine().trim());
    double floatNumber = Double.parseDouble(bufferedReader.readLine().trim());
    String string = bufferedReader.readLine();
    System.out.println("String: " + string);
    System.out.println("Double: " + floatNumber);
    System.out.println("Int: " + intNumber);
    bufferedReader.close();
  }
}
