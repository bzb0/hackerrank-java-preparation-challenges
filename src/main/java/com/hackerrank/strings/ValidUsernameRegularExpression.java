package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ValidUsernameRegularExpression {

  private static final Pattern REGEX = Pattern.compile("[A-Za-z][A-Za-z0-9_]{7,29}");

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    while (n-- > 0) {
      String username = bufferedReader.readLine();
      System.out.println(REGEX.matcher(username).matches() ? "Valid" : "Invalid");
    }
    bufferedReader.close();
  }
}
