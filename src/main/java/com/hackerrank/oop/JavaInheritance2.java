package com.hackerrank.oop;

public class JavaInheritance2 {

  private static class Arithmetic {

    int add(int num1, int num2) {
      return num1 + num2;
    }
  }

  private static class Adder extends Arithmetic {

  }

  public static void main(String[] args) {
    Adder a = new Adder();
    System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());
    System.out.print(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
  }
}