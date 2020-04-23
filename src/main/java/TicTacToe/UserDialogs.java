package TicTacToe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDialogs {

    public static void displayGreetings(String name) {
        System.out.println("Hello, " + name);
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

    public static int getPosition() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number 1 - 9: ");
        return input.nextInt();
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col + "");
            }
            System.out.println();
        }
    }

    public static String getName() {
        while (true) {
            System.out.println("Enter your name: ");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            if (name.length() < 3) {
                System.out.println("Enter at least 3 characters");
            } else {
                return name;
//                System.out.println("Hi " + name);
//                break;
            }
        }
    }

    public static int getRounds() {
        while (true) {
            try {
                System.out.println("Enter number of rounds: ");
                Scanner input = new Scanner(System.in);
                int rounds = input.nextInt();
                if (rounds > 10 || rounds < 1)
                    System.out.println("Enter number between 1 and 10");
                else {
                    return rounds;
                }
            } catch (Exception e) {
                System.out.println("Wrong input, try again.");
            }
        }
    }

    public static void displayWrongNumber() {
        System.out.println("You have to choose empty field");
    }

    public static boolean gameOver(char[][] board, char symbol) {

        if (board[0][1] != ' ' && board[0][1] == board[0][5] && board[0][5] == board[0][9]) return true;
        else if (board[2][1] != ' ' && board[2][1] == board[2][5] && board[2][5] == board[2][9]) return true;
        else if (board[4][1] == 'x' && board[4][5] == 'x' && board[4][9] == 'x') return true;

        else if (board[0][1] == 'x' && board[2][1] == 'x' && board[4][1] == 'x') return true;
        else if (board[0][5] == 'x' && board[2][5] == 'x' && board[4][5] == 'x') return true;
        else if (board[0][9] == 'x' && board[2][9] == 'x' && board[4][9] == 'x') return true;

        else if (board[0][1] == 'x' && board[2][5] == 'x' && board[4][9] == 'x') return true;
        else if (board[4][1] == 'x' && board[2][5] == 'x' && board[0][9] == 'x') return true;
        return false;
    }
}