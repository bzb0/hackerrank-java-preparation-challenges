package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    double payment = Double.parseDouble(bufferedReader.readLine().trim());
    System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
    System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment));
    System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
    System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    bufferedReader.close();
  }
}
