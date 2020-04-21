package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {

    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);
        List<List> winConditions = new ArrayList<>();
        winConditions.add(topRow);
        winConditions.add(middleRow);
        winConditions.add(bottomRow);
        winConditions.add(leftColumn);
        winConditions.add(middleColumn);
        winConditions.add(rightColumn);
        winConditions.add(cross1);
        winConditions.add(cross2);
        return "";
    }
}