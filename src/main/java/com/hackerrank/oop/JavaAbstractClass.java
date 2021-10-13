package com.hackerrank.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaAbstractClass {

  private static abstract class Book {

    String title;

    abstract void setTitle(String s);

    String getTitle() {
      return title;
    }
  }

  private static class MyBook extends Book {

    @Override
    void setTitle(String s) {
      this.title = s;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String title = bufferedReader.readLine();
    MyBook new_novel = new MyBook();
    new_novel.setTitle(title);
    System.out.println("The title is: " + new_novel.getTitle());
    bufferedReader.close();
  }
}
