package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

  private static final Pattern REGEX = Pattern.compile("<(.+)>([^<]+)</\\1>");

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    while (n-- > 0) {
      String line = bufferedReader.readLine();
      boolean matchFound = false;
      Matcher m = REGEX.matcher(line);
      while (m.find()) {
        System.out.println(m.group(2));
        matchFound = true;
      }
      if (!matchFound) {
        System.out.println("None");
      }
    }
    bufferedReader.close();
  }
}
