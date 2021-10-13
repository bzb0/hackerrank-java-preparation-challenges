package com.hackerrank.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class DateAndTime {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE");

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int month = Integer.parseInt(firstMultipleInput[0]);
    int day = Integer.parseInt(firstMultipleInput[1]);
    int year = Integer.parseInt(firstMultipleInput[2]);

    String res = findDay(month, day, year);

    bufferedWriter.write(res);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }

  public static String findDay(int month, int day, int year) {
    return DATE_FORMAT.format(Date.from(LocalDate.of(year, month, day).atStartOfDay().toInstant(ZoneOffset.UTC))).toUpperCase();
  }
}
