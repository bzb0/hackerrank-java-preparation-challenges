package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringTokens {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();
    bufferedReader.close();
    String[] tokens = s.trim().isEmpty() ? new String[0] : s.trim().split("[\\s !,?._'@]+");
    System.out.println(tokens.length);
    Arrays.stream(tokens).forEach(System.out::println);
  }
}
