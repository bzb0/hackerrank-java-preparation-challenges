package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class JavaBitSet {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] sizeAndQuery = bufferedReader.readLine().trim().split(" ");
    int nBits = Integer.parseInt(sizeAndQuery[0]);
    int m = Integer.parseInt(sizeAndQuery[1]);

    BitSet b1 = new BitSet(nBits);
    BitSet b2 = new BitSet(nBits);
    while (m-- > 0) {
      String[] operation = bufferedReader.readLine().trim().split(" ");
      if ("AND".equals(operation[0])) {
        if ("1".equals(operation[1])) {
          b1.and(b2);
        } else {
          b2.and(b1);
        }
      } else if ("OR".equals(operation[0])) {
        if ("1".equals(operation[1])) {
          b1.or(b2);
        } else {
          b2.or(b1);
        }
      } else if ("XOR".equals(operation[0])) {
        if ("1".equals(operation[1])) {
          b1.xor(b2);
        } else {
          b2.xor(b1);
        }
      } else if ("FLIP".equals(operation[0])) {
        if ("1".equals(operation[1])) {
          b1.flip(Integer.parseInt(operation[2]));
        } else {
          b2.flip(Integer.parseInt(operation[2]));
        }
      } else if ("SET".equals(operation[0])) {
        if ("1".equals(operation[1])) {
          b1.set(Integer.parseInt(operation[2]));
        } else {
          b2.set(Integer.parseInt(operation[2]));
        }
      }
      System.out.println(b1.cardinality() + " " + b2.cardinality());
    }
    bufferedReader.close();
  }
}
