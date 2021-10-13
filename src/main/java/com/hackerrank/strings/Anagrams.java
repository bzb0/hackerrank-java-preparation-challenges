package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagrams {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String a = bufferedReader.readLine();
    String b = bufferedReader.readLine();
    bufferedReader.close();
    System.out.println(isAnagram(a, b) ? "Anagrams" : "Not Anagrams");
  }

  private static boolean isAnagram(String a, String b) {
    Map<Integer, Long> frequenciesA = a.chars().mapToObj(Character::toLowerCase)
        .collect((Collectors.groupingBy(Function.identity(), Collectors.counting())));
    Map<Integer, Long> frequenciesB = b.chars().mapToObj(Character::toLowerCase)
        .collect((Collectors.groupingBy(Function.identity(), Collectors.counting())));
    return frequenciesA.equals(frequenciesB);
  }
}
