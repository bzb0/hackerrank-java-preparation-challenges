package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class JavaPriorityQueue {

  private static class Student {

    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
      this.id = id;
      this.name = name;
      this.cgpa = cgpa;
    }

    public int getID() {
      return id;
    }

    public String getName() {
      return name;
    }

    public double getCGPA() {
      return cgpa;
    }
  }

  private static class Priorities {

    PriorityQueue<Student> queue = new PriorityQueue<>((o1, o2) -> {
      if (Double.compare(o1.getCGPA(), o2.getCGPA()) == 0) {
        if (o1.getName().compareTo(o2.getName()) == 0) {
          return Integer.compare(o1.getID(), o2.getID());
        }
        return o1.getName().compareTo(o2.getName());
      }
      return Double.compare(o2.getCGPA(), o1.getCGPA());
    });

    List<Student> getStudents(List<String> events) {
      for (String event : events) {
        String[] studentData = event.split(" ");
        if ("ENTER".equals(studentData[0])) {
          queue.offer(new Student(Integer.parseInt(studentData[3].trim()), studentData[1].trim(), Double.parseDouble(studentData[2].trim())));
        } else if ("SERVED".equals(studentData[0])) {
          queue.poll();
        }
      }
      List<Student> result = new ArrayList<>();
      while (!queue.isEmpty()) {
        result.add(queue.poll());
      }
      return result;
    }
  }

  private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) throws IOException {
    int totalEvents = Integer.parseInt(bufferedReader.readLine());
    List<String> events = new ArrayList<>();
    while (totalEvents-- != 0) {
      String event = bufferedReader.readLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);
    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}