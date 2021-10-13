package com.hackerrank.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class JavaIterator {

  static Iterator<Object> func(ArrayList<Object> mylist) {
    Iterator<Object> it = mylist.iterator();
    while (it.hasNext()) {
      Object element = it.next();
      //Hints: use instanceof operator
      if (element instanceof String) {
        break;
      }
    }
    return it;

  }

  public static void main(String[] args) throws IOException {
    ArrayList<Object> mylist = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] tokens = bufferedReader.readLine().split(" ");
    int n = Integer.parseInt(tokens[0]);
    int m = Integer.parseInt(tokens[1]);
    for (int i = 0; i < n; i++) {
      mylist.add(Integer.parseInt(bufferedReader.readLine()));
    }

    mylist.add("###");
    for (int i = 0; i < m; i++) {
      mylist.add(bufferedReader.readLine());
    }

    Iterator<Object> it = func(mylist);
    while (it.hasNext()) {
      Object element = it.next();
      System.out.println((String) element);
    }
    bufferedReader.close();
  }
}