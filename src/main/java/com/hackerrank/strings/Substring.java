package com.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Substring {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();
    String[] range = bufferedReader.readLine().split(" ");
    int start = Integer.parseInt(range[0]);
    int end = Integer.parseInt(range[1]);
    bufferedReader.close();
    System.out.println(s.substring(start, end));
  }
}
