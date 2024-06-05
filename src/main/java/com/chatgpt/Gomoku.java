package com.chatgpt;

import java.util.Scanner;

public class Gomoku {
  static final int SIZE = 15;
  static final char[][] board = new char[SIZE][SIZE];
  static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    initBoard();
    while (true) {
      System.out.println("请输入你下棋的坐标，应以x,y的格式：");
      int x = sc.nextInt();
      int y = sc.nextInt();
      board[x][y] = 'X';
      printBoard();
      if (checkWin(x, y)) {
        System.out.println("你赢了！");
        break;
      }
      System.out.println("请等待电脑下棋...");
      int[] computerMove = generateComputerMove();
      x = computerMove[0];
      y = computerMove[1];
      board[x][y] = 'O';
      printBoard();
      if (checkWin(x, y)) {
        System.out.println("电脑赢了！");
        break;
      }
    }
  }

  public static void initBoard() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = '.';
      }
    }
  }

  public static void printBoard() {
    System.out.println("  1 2 3 4 5 6 7 8 9 101112131415");
    for (int i = 0; i < SIZE; i++) {
      System.out.print((i + 1) + " ");
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean checkWin(int x, int y) {
    int count = 0;
    // 横向检查
    for (int i = y - 4; i <= y; i++) {
      if (i >= 0 && board[x][i] == board[x][y]) {
        count++;
      } else {
        count = 0;
      }
      if (count == 5) {
        return true;
      }
    }
    count = 0;
    // 纵向检查
    for (int i = x - 4; i <= x; i++) {
      if (i >= 0 && board[i][y] == board[x][y]) {
        count++;
      } else {
        count = 0;
      }
      if (count == 5) {
        return true;
      }
    }
    count = 0;
    // 斜向检查（左上到右下）
    for (int i = x - 4, j = y - 4; i <= x && j <= y; i++, j++) {
      if (i >= 0 && j >= 0 && board[i][j] == board[x][y]) {
        count++;
      } else {
        count = 0;
      }
      if (count == 5) {
        return true;
      }
    }
    count = 0;
    // 斜向检查（右上到左下）
    for (int i = x - 4, j = y + 4; i <= x && j >= 0; i++, j--) {
      if (i >= 0 && j < SIZE && board[i][j] == board[x][y]) {
        count++;
      } else {
        count = 0;
      }
      if (count == 5) {
        return true;
      }
    }
    return false;
  }

  public static int[] generateComputerMove() {
    int x = (int) (Math.random() * SIZE);
    int y = (int) (Math.random() * SIZE);
    return new int[] {x, y};
  }
}

