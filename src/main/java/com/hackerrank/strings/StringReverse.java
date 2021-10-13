package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String a = bufferedReader.readLine();
    bufferedReader.close();
    for (int i = 0; i < a.length() / 2; i++) {
      if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }
}
