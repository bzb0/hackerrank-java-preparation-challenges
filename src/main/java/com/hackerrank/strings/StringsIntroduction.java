package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsIntroduction {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String a = bufferedReader.readLine().trim();
    String b = bufferedReader.readLine().trim();
    bufferedReader.close();
    System.out.println(a.length() + b.length());
    System.out.println(a.compareTo(b) > 0 ? "Yes" : "No");
    System.out.println(Character.toUpperCase(a.charAt(0)) + a.substring(1) + " " + Character.toUpperCase(b.charAt(0)) + b.substring(1));
  }
}
