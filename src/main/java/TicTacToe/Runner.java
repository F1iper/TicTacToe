package TicTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static TicTacToe.Board.*;

public class Runner {
    private static Scanner input = new Scanner(System.in);
    static char[][] board = {
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}};

    public static void run() {

//        getName();
//        getRounds();
        showExampleBoard();
        while (true) {
            try {
                System.out.println("Enter number 1 - 9: ");
                int playerPos = input.nextInt();
                placePiece(board, playerPos, "player");

                Random rnd = new Random();
                int pcPos = rnd.nextInt(9) + 1;
                placePiece(board, pcPos, "pc");

                printBoard(board);

            } catch (InputMismatchException e) {
                System.out.println("Wrong input.");

            }
        }
    }
}