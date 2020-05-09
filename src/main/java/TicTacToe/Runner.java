package TicTacToe;

import static TicTacToe.UserDialogs.getName;
import static TicTacToe.UserDialogs.getRounds;

public class Runner {

    public void run() throws Exception {

        String name = getName();
        int rounds = getRounds();
        TextGame textGame = new TextGame(name, rounds);
        textGame.play();
    }
}