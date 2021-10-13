package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaRegex {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      System.out.println(line.matches(new MyRegex().pattern));
    }
  }

  static class MyRegex {

    String pattern = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])" + "\\."
        + "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])" + "\\."
        + "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])" + "\\."
        + "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
  }
}
