package TicTacToe;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import static TicTacToe.GameOver.gameOver;

public class Game {
    private final GridPane gridPane;
    private final Image x = new Image("file/x.png", 150, 150, true, true);
    private final Image o = new Image("file/o.png", 150, 150, true, true);
    private Board board;
    private String player = Board.PLAYER;

    public Game(GridPane gridPane, Board board) {
        this.gridPane = gridPane;
        this.board = board;
    }

    public void doClick(int x, int y) {
        boolean isMove = board.placePiece(x, y, player);
        if (isMove) {
            player = switchPlayer(player);
            display();
            if (board.gameOver()) {
                System.out.println("game over");
                board = new Board();
                player = Board.PLAYER;
                gameOver();
                display();
            }
        }
    }

    public void display() {
        gridPane.getChildren().clear();
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {

                char figure = board.getPiece(row, col);
                ImageView imageView = new ImageView();
                if (figure == 'o')
                    imageView = new ImageView(o);
                else if (figure == 'x')
                    imageView = new ImageView(x);
                gridPane.add(imageView, row, col);

            }
        }
    }

    private String switchPlayer(String player) {
        return player.equals(Board.PLAYER) ? Board.PC : Board.PLAYER;
    }
}