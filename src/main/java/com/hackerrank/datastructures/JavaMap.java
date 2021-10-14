package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JavaMap {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    Map<String, Integer> phoneBook = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String name = bufferedReader.readLine();
      int phone = Integer.parseInt(bufferedReader.readLine());
      phoneBook.put(name, phone);
    }
    String line;
    while ((line = bufferedReader.readLine()) != null ) {
      if (phoneBook.containsKey(line)) {
        System.out.println(line + "=" + phoneBook.get(line));
      } else {
        System.out.println("Not found");
      }
    }
  }
}
