package com.hackerrank.advanced;

import com.hackerrank.advanced.FactoryPattern.Do_Not_Terminate.ExitTrappedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Permission;

public class FactoryPattern {

  interface Food {

    String getType();
  }

  private static class Pizza implements Food {

    public String getType() {
      return "Someone ordered a Fast Food!";
    }
  }

  private static class Cake implements Food {

    public String getType() {
      return "Someone ordered a Dessert!";
    }
  }

  private static class FoodFactory {

    public Food getFood(String order) {
      if ("cake".equals(order)) {
        return new Cake();
      }
      if ("pizza".equals(order)) {
        return new Pizza();
      }
      return null;
    }
  }

  public static void main(String args[]) {
    Do_Not_Terminate.forbidExit();

    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      //creating the factory
      FoodFactory foodFactory = new FoodFactory();

      //factory instantiates an object
      Food food = foodFactory.getFood(reader.readLine());
      reader.close();

      System.out.println("The factory returned " + food.getClass());
      System.out.println(food.getType());
    } catch (ExitTrappedException | IOException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  }

  static class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {

      private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
      final SecurityManager securityManager = new SecurityManager() {
        @Override
        public void checkPermission(Permission permission) {
          if (permission.getName().contains("exitVM")) {
            throw new ExitTrappedException();
          }
        }
      };
      System.setSecurityManager(securityManager);
    }
  }
}
