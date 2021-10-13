package com.hackerrank.bignumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

class JavaBigDecimal {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = bufferedReader.readLine();
    }
    bufferedReader.close();

    Arrays.sort(s, (o1, o2) -> new BigDecimal(o2).compareTo(new BigDecimal(o1)));
    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }
}
