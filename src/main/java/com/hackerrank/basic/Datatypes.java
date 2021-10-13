package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Datatypes {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    while (n-- > 0) {
      String numStr = bufferedReader.readLine().trim();
      try {
        long num = Long.parseLong(numStr);
        System.out.println(num + " can be fitted in:");
        if (num >= -128 && num <= 127) {
          System.out.println("* byte");
        }
        if (num >= -32768 && num <= 32767) {
          System.out.println("* short");
        }
        if (num >= -2147483648 && num <= 2147483647) {
          System.out.println("* int");
        }
        System.out.println("* long");
      } catch (Exception e) {
        System.out.println(numStr + " can't be fitted anywhere.");
      }
    }
    bufferedReader.close();
  }
}
