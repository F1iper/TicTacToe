package TicTacToe;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Game {
    private final GridPane gridPane;
    private final Board board;
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
            if(board.gameOver()){
                // todo : display game over msg
            }
        }
    }

    public void display() {
        gridPane.getChildren().clear();
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                char figure = board.getPiece(col, row);
                Rectangle r = new Rectangle(200, 200, null);
                r.setStroke(Color.BLACK);
                gridPane.add(r, row, col);

                Text text = new Text(getSymbol(figure));
                text.setFont(Font.font(80));
                gridPane.add(text, row, col);
            }
        }
    }

    private String getSymbol(char figure) {
        switch(figure){
            case 'x': return "x";
            case 'o': return "O";
            default: return " ";
        }
    }

    private String switchPlayer(String player) {
        return player.equals(Board.PLAYER) ? Board.PC : Board.PLAYER;
    }
}