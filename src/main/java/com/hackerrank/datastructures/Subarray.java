package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Subarray {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    int[] array = new int[n];
    String line = bufferedReader.readLine();
    String[] elements = line.split(" ");
    for (int i = 0; i < elements.length; i++) {
      array[i] = Integer.parseInt(elements[i]);
    }

    int cnt = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j < array.length; j++) {
        cnt = (Arrays.stream(Arrays.copyOfRange(array, i, j + 1)).sum() < 0) ? cnt + 1 : cnt;
      }
    }
    System.out.println(cnt);
    bufferedReader.close();
  }
}
