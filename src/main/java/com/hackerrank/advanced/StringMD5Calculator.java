package com.hackerrank.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringMD5Calculator {

  public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine().trim();
    bufferedReader.close();

    MessageDigest digest = MessageDigest.getInstance("MD5");
    byte[] hashedBytes = digest.digest(s.getBytes());
    StringBuilder builder = new StringBuilder();
    for (byte hashedByte : hashedBytes) {
      builder.append(Integer.toString((hashedByte & 0xff) + 0x100, 16).substring(1));
    }
    System.out.println(builder);
  }
}
