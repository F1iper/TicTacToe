package TicTacToe;

import java.util.Scanner;

public class Board {
    static char[][] board = {
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}};

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col + "");
            }
            System.out.println();
        }
    }

    public static void showExampleBoard() {
        System.out.println("Take a look at sample board: ");
        char[][] exampleBoard = {
                {' ', '1', ' ', '|', ' ', '2', ' ', '|', ' ', '3', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
                {' ', '4', ' ', '|', ' ', '5', ' ', '|', ' ', '6', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
                {' ', '7', ' ', '|', ' ', '8', ' ', '|', ' ', '9', ' '}};
        for (int i = 0; i < exampleBoard.length; i++) {
            for (int j = 0; j < exampleBoard[i].length; j++) {
                System.out.print(exampleBoard[i][j] + "");
            }
            System.out.println();
        }
    }

//    public static char[][] initializeBoard(char[][] board) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + "");
//            }
//            System.out.println();
//        }
//        return board;
//    }

    public static void placePiece(char[][] board, int pos, String user) {
        char symbol = ' ';
        if(user.equals("player"))
            symbol = 'x';
        else if(user.equals("pc"))
            symbol = 'o';

        switch (pos) {
            case 1:
                board[0][1] = symbol;
                break;
            case 2:
                board[0][5] = symbol;
                break;
            case 3:
                board[0][9] = symbol;
                break;
            case 4:
                board[2][1] = symbol;
                break;
            case 5:
                board[2][5] = symbol;
                break;
            case 6:
                board[2][9] = symbol;
                break;
            case 7:
                board[4][1] = symbol;
                break;
            case 8:
                board[4][5] = symbol;
                break;
            case 9:
                board[4][9] = symbol;
                break;
            default:
                System.out.println("Wrong input, try again.");
        }
    }
}