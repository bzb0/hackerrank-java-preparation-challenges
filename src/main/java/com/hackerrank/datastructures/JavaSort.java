package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JavaSort {

  private static class Student {

    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
      super();
      this.id = id;
      this.fname = fname;
      this.cgpa = cgpa;
    }

    public int getId() {
      return id;
    }

    public String getFname() {
      return fname;
    }

    public double getCgpa() {
      return cgpa;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(bufferedReader.readLine());

    List<Student> studentList = new ArrayList<Student>();
    while (testCases > 0) {
      String[] tokens = bufferedReader.readLine().trim().split(" ");
      int id = Integer.parseInt(tokens[0]);
      String fname = tokens[1];
      double cgpa = Double.parseDouble(tokens[2]);

      Student st = new Student(id, fname, cgpa);
      studentList.add(st);
      testCases--;
    }
    bufferedReader.close();

    studentList.sort((o1, o2) -> {
      if (o1.getCgpa() == o2.getCgpa()) {
        if (o1.getFname().equals(o2.getFname())) {
          return o1.getId() - o2.getId();
        }
        return o1.getFname().compareTo(o2.getFname());
      }
      return o1.getCgpa() > o2.getCgpa() ? -1 : 1;
    });
    for (Student st : studentList) {
      System.out.println(st.getFname());
    }
  }
}