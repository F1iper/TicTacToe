package TicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private final int ROWS = 3;
    private final int COLS = 3;
    private int row, col;
    private boolean playable = true;
    private boolean turnX = true;
    private Text text;
    private Rectangle r;
    private GridPane gridPane;
    private Scene scene1, scene2;

    public static void main(String[] args) throws Exception {
        launch(args);
//        Runner runner = new Runner();
//        runner.run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(true);
        primaryStage.setTitle("TIC TAC TOE");

        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file/fire.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        gridPane = new GridPane();
        gridPane.setBackground(background);

        scene2 = new Scene(gridPane, 600, 600);

//        createBoard(gridPane);
        Board board = new Board();
        Game game = new Game(gridPane, board);
        game.display();
        gridPane.setOnMouseClicked(event -> {
            System.out.println(event.getX());
            System.out.println(event.getY());
            int x = (int) (event.getX()/200);
            int y = (int) (event.getY()/200);
            System.out.println(x + ", " + y);
            game.doClick(y, x);
            System.out.println(board.getBoard());
//            if (!playable)
//                return;
//            if (event.getButton() == MouseButton.PRIMARY) {
//                if (!turnX)
//                    return;
//                drawX();
//                turnX = false;
//                checkState();
//            } else if (event.getButton() == MouseButton.SECONDARY) {
//                if (turnX)
//                    return;
//                drawO();
//                turnX = true;
//                checkState();
//            }
        });

        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    private void checkState() {

    }

    private void createBoard(GridPane grid) {
        for (row = 0; row < ROWS; row++) {
            for (col = 0; col < COLS; col++) {
                r = new Rectangle(200, 200, null);
                r.setStroke(Color.BLACK);
                grid.add(r, row, col);

                text = new Text("");
                text.setFont(Font.font(80));
                grid.add(text, row, col);
            }
        }
    }

    private void drawX() {
        text.setText("x");
    }

    private void drawO() {
        text.setText("o");
    }
}