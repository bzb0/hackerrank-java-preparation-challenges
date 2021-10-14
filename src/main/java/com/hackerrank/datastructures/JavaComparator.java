package com.hackerrank.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class JavaComparator {

  private static class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
      if (o1.score == o2.score) {
        return o1.name.compareTo(o2.name);
      }
      return o2.score - o1.score;
    }
  }

  private static class Player {

    String name;
    int score;

    Player(String name, int score) {
      this.name = name;
      this.score = score;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());

    Player[] player = new Player[n];
    Checker checker = new Checker();

    for (int i = 0; i < n; i++) {
      String[] tokens = bufferedReader.readLine().trim().split(" ");
      player[i] = new Player(tokens[0], Integer.parseInt(tokens[1]));
    }
    bufferedReader.close();

    Arrays.sort(player, checker);
    for (int i = 0; i < player.length; i++) {
      System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
  }
}