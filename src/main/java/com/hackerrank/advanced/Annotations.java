package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Annotations {

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  @interface FamilyBudget {

    String userRole() default "GUEST";

    int budgetLimit();
  }

  private static class FamilyMember {

    @FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
    public void seniorMember(int budget, int moneySpend) {
      System.out.println("Senior Member");
      System.out.println("Spend: " + moneySpend);
      System.out.println("Budget Left: " + (budget - moneySpend));
    }

    @FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
    public void juniorUser(int budget, int moneySpend) {
      System.out.println("Junior Member");
      System.out.println("Spend: " + moneySpend);
      System.out.println("Budget Left: " + (budget - moneySpend));
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(bufferedReader.readLine());
    while (testCases > 0) {
      String[] tokens = bufferedReader.readLine().trim().split(" ");
      String role = tokens[0];
      int spend = Integer.parseInt(tokens[1]);
      try {
        Class annotatedClass = FamilyMember.class;
        Method[] methods = annotatedClass.getMethods();
        for (Method method : methods) {
          if (method.isAnnotationPresent(FamilyBudget.class)) {
            FamilyBudget family = method.getAnnotation(FamilyBudget.class);
            String userRole = family.userRole();
            int budgetLimit = family.budgetLimit();
            if (userRole.equals(role)) {
              if (spend <= budgetLimit) {
                method.invoke(FamilyMember.class.newInstance(), budgetLimit, spend);
              } else {
                System.out.println("Budget Limit Over");
              }
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      testCases--;
    }
  }
}
