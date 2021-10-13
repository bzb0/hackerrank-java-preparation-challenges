package com.hackerrank.bignumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaBigInteger {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String a = bufferedReader.readLine().trim();
    String b = bufferedReader.readLine().trim();
    System.out.println(new BigInteger(a).add(new BigInteger(b)));
    System.out.println(new BigInteger(a).multiply(new BigInteger(b)));
    bufferedReader.close();
  }
}
