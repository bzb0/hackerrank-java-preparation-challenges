package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    int numSentences = Integer.parseInt(bufferedReader.readLine());
    while (numSentences-- > 0) {
      String input = bufferedReader.readLine();
      Matcher m = p.matcher(input);
      while (m.find()) {
        input = input.replaceAll(m.group(), m.group(1));
      }
      System.out.println(input);
    }
    bufferedReader.close();
  }
}
