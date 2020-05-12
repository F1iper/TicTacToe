package TicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    private GridPane gridPane;
    private Scene scene2;

    public static void main(String[] args) throws Exception {
        launch(args);
//        Runner runner = new Runner();
//        runner.run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setTitle("TIC TAC TOE");

        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file/fire.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        gridPane = new GridPane();
        for (int n = 0; n < 3; n++) {
            gridPane.getRowConstraints().add(new RowConstraints(200));
            gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        }

        gridPane.setBackground(background);
        scene2 = new Scene(gridPane, 600, 600);

        Board board = new Board();
        Game game = new Game(gridPane, board);
        game.display();

        gridPane.setOnMouseClicked(event -> {
            System.out.println(event.getX());
            System.out.println(event.getY());
            int x = (int) (event.getX() / 200);
            int y = (int) (event.getY() / 200);
            System.out.println(y + ", " + x);
            System.out.println(x + " " + y);

            game.doClick(x, y);
        });

        primaryStage.setScene(scene2);
        primaryStage.show();

    }
}