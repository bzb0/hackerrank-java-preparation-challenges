package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class JavaDequeue {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Deque<Integer> deque = new ArrayDeque<>();
    String[] tokens = bufferedReader.readLine().trim().split(" ");
    int n = Integer.parseInt(tokens[0]);
    int m = Integer.parseInt(tokens[1]);

    int maxUnique = 0;
    Map<Integer, Integer> counts = new HashMap<>();
    String[] numTokens = bufferedReader.readLine().trim().split(" ");
    bufferedReader.close();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(numTokens[i]);
      if (deque.size() == m) {
        int removed = deque.removeFirst();
        if (counts.containsKey(removed)) {
          if (counts.get(removed) == 1) {
            counts.remove(removed);
          } else {
            counts.put(removed, counts.get(removed) - 1);
          }
        }
      }
      deque.addLast(num);
      counts.merge(num, 1, (k, v) -> v + 1);
      maxUnique = Math.max(maxUnique, counts.size());
    }
    System.out.println(maxUnique);
  }
}