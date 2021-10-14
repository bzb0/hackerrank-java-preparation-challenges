package com.hackerrank.datastructures;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java2DArray {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<List<Integer>> arr = new ArrayList<>();
    IntStream.range(0, 6).forEach(i -> {
      try {
        arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList()));
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int maxSum = Integer.MIN_VALUE, currSum = 0;
    for (int i = 0; i < arr.size() - 2; i++) {
      for (int j = 0; j <= arr.get(i).size() - 3; j++) {
        currSum += arr.get(i).subList(j, j + 3).stream().mapToInt(elem -> elem).sum();
        currSum += arr.get(i + 1).get(j + 1);
        currSum += arr.get(i + 2).subList(j, j + 3).stream().mapToInt(elem -> elem).sum();
        maxSum = Math.max(maxSum, currSum);
        currSum = 0;
      }
    }
    System.out.println(maxSum);

    bufferedReader.close();
  }
}
