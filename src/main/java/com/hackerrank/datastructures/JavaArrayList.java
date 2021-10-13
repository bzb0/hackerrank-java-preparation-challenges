package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JavaArrayList {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());
    List<List<Integer>> lists = new ArrayList<>(n);
    while (n-- > 0) {
      String line = bufferedReader.readLine();
      String[] elements = line.split(" ");
      int size = Integer.parseInt(elements[0]);
      lists.add(new ArrayList<>(size));
      for (int i = 1; i < elements.length; i++) {
        lists.get(lists.size() - 1).add(Integer.parseInt(elements[i]));
      }
    }

    int q = Integer.parseInt(bufferedReader.readLine().trim());
    while (q-- > 0) {
      String line = bufferedReader.readLine();
      String[] position = line.split(" ");
      int x = Integer.parseInt(position[0]);
      int y = Integer.parseInt(position[1]);
      try {
        System.out.println(lists.get(x - 1).get(y - 1));
      } catch (IndexOutOfBoundsException e) {
        System.out.println("ERROR!");
      }
    }
    bufferedReader.close();
  }
}
