package org.example.service;

import java.util.Scanner;

public class Game {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char gamer = 'X';

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            makeMove();

            if (checkWin() || isBoardFull()) {
                printBoard();
                if (checkWin()) {
                    System.out.println("O'yinchi " + gamer + " g'alaba qozondi!");
                } else {
                    System.out.println("Do'stlik!");
                }
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("O'yinchi " + gamer + ", joylashuvni kiriting: (qator va ustun): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = gamer;
                break;
            } else {
                System.out.println("Xato kiritdingiz qaytadan urinib ko'ring!");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == gamer && board[i][1] == gamer && board[i][2] == gamer) {
                return true;
            }
            if (board[0][i] == gamer && board[1][i] == gamer && board[2][i] == gamer) {
                return true;
            }
        }

        if (board[0][0] == gamer && board[1][1] == gamer && board[2][2] == gamer) {
            return true;
        }
        if (board[0][2] == gamer && board[1][1] == gamer && board[2][0] == gamer) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        gamer = (gamer == 'X') ? 'O' : 'X';
    }
}
