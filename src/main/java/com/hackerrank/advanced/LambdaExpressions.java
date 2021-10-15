package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LambdaExpressions {

  interface PerformOperation {

    boolean check(int a);
  }

  private static class MyMath {

    public static boolean checker(PerformOperation p, int num) {
      return p.check(num);
    }

    PerformOperation isOdd() {
      return (num) -> num % 2 == 1;
    }

    PerformOperation isPrime() {
      return (num) -> {
        if (num < 2) {
          return false;
        }
        for (int i = 2; i < num / 2; i++) {
          if (num % i == 0) {
            return false;
          }
        }
        return true;
      };
    }

    PerformOperation isPalindrome() {
      return (num) -> {
        int reversedNum = 0, remainder, originalNum = num;
        while (num != 0) {
          remainder = num % 10;
          reversedNum = reversedNum * 10 + remainder;
          num /= 10;
        }
        return originalNum == reversedNum;
      };
    }
  }

  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret = false;
    String ans = null;
    while (T-- > 0) {
      String s = br.readLine().trim();
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

      }
      System.out.println(ans);
    }
  }
}
