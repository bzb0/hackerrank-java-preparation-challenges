package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class JavaStack {

  public static void main(String[] argh) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      int closingCnt = 0;
      Deque<Character> stack = new ArrayDeque<>();
      for (int i = 0; i < line.length(); i++) {
        if (line.charAt(i) == '{' || line.charAt(i) == '(' || line.charAt(i) == '[') {
          stack.push(line.charAt(i));
          closingCnt++;
        } else {
          if (closingCnt == 0) {
            closingCnt = -1;
            break;
          }
          char currChar = stack.peek();
          if ((currChar == '{' && line.charAt(i) == '}') || (currChar == '[' && line.charAt(i) == ']')
              || (currChar == '(' && line.charAt(i) == ')')) {
            stack.pop();
            closingCnt--;
          }
        }
      }
      System.out.println(closingCnt % 2 == 0);
    }
  }
}
