package TicTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameOver {

    public static void gameOver() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Game over");
        window.setMinWidth(400);
        window.setMinHeight(400);

        Label label = new Label("Game over!");
        label.setFont(Font.font(75));
        Button ok = new Button("Ok");
        ok.setPrefSize(120, 40);
        ok.setOnAction(e -> window.close());

        VBox layout = new VBox();
        layout.setPadding(new Insets(100, 100, 100, 100));
        layout.getChildren().addAll(label, ok);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}