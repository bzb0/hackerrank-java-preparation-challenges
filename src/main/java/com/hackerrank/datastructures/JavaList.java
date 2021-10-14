package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JavaList {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    List<Integer> list = new ArrayList<>(n);
    String line = bufferedReader.readLine();
    String[] elements = line.split(" ");
    for (int i = 0; i < elements.length; i++) {
      list.add(Integer.parseInt(elements[i]));
    }

    int q = Integer.parseInt(bufferedReader.readLine().trim());
    while (q-- > 0) {
      String query = bufferedReader.readLine().trim();
      String position = bufferedReader.readLine().trim();
      if ("Insert".equals(query)) {
        String[] posElem = position.split(" ");
        list.add(Integer.parseInt(posElem[0]), Integer.parseInt(posElem[1]));
      } else if ("Delete".equals(query)) {
        list.remove(Integer.parseInt(position));
      }
    }

    for (int i = 0; i < list.size(); i++) {
      if ((i + 1) == list.size()) {
        System.out.print(list.get(i));
      } else {
        System.out.print(list.get(i) + " ");
      }
    }
    bufferedReader.close();
  }
}
