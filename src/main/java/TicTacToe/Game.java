package TicTacToe;

import java.util.Random;

import static TicTacToe.UserDialogs.gameOver;
import static TicTacToe.UserDialogs.restartGame;

public class Game {
    private final String name;
    private final int rounds;

    public Game(String name, int rounds) {
        this.name = name;
        this.rounds = rounds;
    }

    public void play() throws Exception {
        UserDialogs.displayGreetings(name);
        UserDialogs.showExampleBoard();
        Board board = new Board();
        Random rnd = new Random();
        while (true) {
            while (true) {
                int playerPos = UserDialogs.getPosition();
                if (board.placePiece(playerPos, Board.PLAYER))
                    break;
                UserDialogs.displayWrongNumber();
            }
            if (gameOver(board.getBoard())) {
                UserDialogs.printBoard(board.getBoard());
                UserDialogs.displayWinner(Board.PLAYER);
                if (restartGame())
                    play();
                break;
            }
            while (true) {
                int pcPos = rnd.nextInt(9) + 1;
                if (board.placePiece(pcPos, Board.PC)) {
                    break;
                }
            }
            if (gameOver(board.getBoard())) {
                UserDialogs.printBoard(board.getBoard());
                UserDialogs.displayWinner(Board.PC);
                if (restartGame())
                    play();
                break;
            }
            UserDialogs.printBoard(board.getBoard());
        }
    }
}