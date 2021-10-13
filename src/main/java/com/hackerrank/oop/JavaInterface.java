package com.hackerrank.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class JavaInterface {

  private interface AdvancedArithmetic {

    int divisor_sum(int n);
  }

  private static class MyCalculator implements AdvancedArithmetic {

    public int divisor_sum(int n) {
      int sum = 0;
      for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
          sum += i;
        }
      }
      return sum;
    }
  }

  public static void main(String[] args) throws IOException {
    MyCalculator my_calculator = new MyCalculator();
    System.out.print("I implemented: ");
    ImplementedInterfaceNames(my_calculator);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    System.out.print(my_calculator.divisor_sum(n) + "\n");
    bufferedReader.close();
  }

  /*
   *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
   */
  static void ImplementedInterfaceNames(Object o) {
    Class[] theInterfaces = o.getClass().getInterfaces();
    for (int i = 0; i < theInterfaces.length; i++) {
      String interfaceName = theInterfaces[i].getName();
      System.out.println(interfaceName);
    }
  }
}