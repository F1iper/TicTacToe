package TicTacToe;

import java.util.Random;

import static TicTacToe.UserDialogs.*;

public class Game {
    private final String name;
    private final int rounds;

    public Game(String name, int rounds) {
        this.name = name;
        this.rounds = rounds;
    }

    public void play() {
        UserDialogs.displayGreetings(name);
        UserDialogs.showExampleBoard();
        Board board = new Board();
        Random rnd = new Random();
        while (true) {
            while (true) {
                try {
                    int playerPos = UserDialogs.getPosition();
                    if (board.placePiece(playerPos, Board.PLAYER))
                        break;
                    UserDialogs.displayWrongNumber();
                } catch (Exception e) {
                    System.out.println("Wrong input, try again.");
                }
            }
            if (!gameOver(board.getBoard()) && isBoardFull(board.getBoard())) {
                System.out.println("It's a tie!");
                if (restartGame())
                    play();
            } else if (gameOver(board.getBoard())) {
                UserDialogs.printBoard(board.getBoard());
                UserDialogs.displayWinner(Board.PLAYER);
                if (restartGame())
                    play();
                else
                    System.exit(0);
            }
            while (true) {
                int pcPos = rnd.nextInt(9) + 1;
                if (board.placePiece(pcPos, Board.PC))
                    break;
            }
            if (!gameOver(board.getBoard()) && isBoardFull(board.getBoard())) {
                System.out.println("It's a tie!");
                if (restartGame())
                    play();
                else
                    System.exit(0);

            } else if (gameOver(board.getBoard())) {
                UserDialogs.printBoard(board.getBoard());
                UserDialogs.displayWinner(Board.PC);
                if (restartGame())
                    play();
                else
                    System.exit(0);
            }
            UserDialogs.printBoard(board.getBoard());
        }
    }
}