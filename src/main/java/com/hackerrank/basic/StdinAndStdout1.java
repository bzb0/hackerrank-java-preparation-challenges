package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdinAndStdout1 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int number1 = Integer.parseInt(bufferedReader.readLine().trim());
    int number2 = Integer.parseInt(bufferedReader.readLine().trim());
    int number3 = Integer.parseInt(bufferedReader.readLine().trim());
    System.out.println(number1);
    System.out.println(number2);
    System.out.println(number3);
    bufferedReader.close();
  }
}
