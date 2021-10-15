package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CovariantReturnTypes {

  private static class Flower {

    String whatsYourName() {
      return "I have many names and types.";
    }
  }

  private static class Jasmine extends Flower {

    String whatsYourName() {
      return "Jasmine";
    }
  }

  private static class Lily extends Flower {

    String whatsYourName() {
      return "Lily";
    }
  }

  private static class Region {

    Flower yourNationalFlower() {
      return new Flower();
    }
  }

  private static class WestBengal extends Region {

    Flower yourNationalFlower() {
      return new Jasmine();
    }
  }

  private static class AndhraPradesh extends Region {

    Flower yourNationalFlower() {
      return new Lily();
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine().trim();
    Region region = null;
    switch (s) {
      case "WestBengal":
        region = new WestBengal();
        break;
      case "AndhraPradesh":
        region = new AndhraPradesh();
        break;
    }
    Flower flower = region.yourNationalFlower();
    System.out.println(flower.whatsYourName());
  }
}