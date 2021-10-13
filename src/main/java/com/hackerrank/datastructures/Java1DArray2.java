package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java1DArray2 {

  public static boolean canWin(int leap, int[] game) {
    return backtrack(leap, game, 0);
  }

  private static boolean backtrack(int leap, int[] game, int i) {
    if (i == game.length - 1 || i + leap >= game.length) {
      return true;
    }
    boolean resultIncrement = false, resultLeap = false, resultDecrement = false;
    if (game[i + leap] == 0) {
      game[i + leap] = -1;
      resultIncrement = backtrack(leap, game, i + leap);
    }
    if (game[i + 1] == 0) {
      game[i + 1] = -1;
      resultLeap = backtrack(leap, game, i + 1);
    }
    if ((i - 1 >= 0) && game[i - 1] == 0) {
      game[i - 1] = -1;
      resultDecrement = backtrack(leap, game, i - 1);
    }
    return resultIncrement || resultLeap || resultDecrement;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(bufferedReader.readLine());
    while (q-- > 0) {
      String[] tokens = bufferedReader.readLine().trim().split(" ");
      int n = Integer.parseInt(tokens[0]);
      int leap = Integer.parseInt(tokens[1]);

      int[] game = new int[n];
      String[] gameTokens = bufferedReader.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        game[i] = Integer.parseInt(gameTokens[i]);
      }
      System.out.println((canWin(leap, game)) ? "YES" : "NO");
    }
    bufferedReader.close();
  }
}
