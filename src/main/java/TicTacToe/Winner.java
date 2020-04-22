package TicTacToe;

public class Winner {

}
public static
        boolean topRow = (board[0][1] != ' ' && board[0][1] == board[0][5] && board[0][5] == board[0][9]);
        boolean middleRow = (board[2][1] != ' ' && board[2][1] == board[2][5] && board[2][5] == board[2][9]);
        boolean bottomRow = (board[4][1] != ' ' && board[4][1] == board[4][5] && board[4][5] == board[4][9]);

        boolean leftColumn = (board[0][1] != ' ' && board[0][1] == board[2][1] && board[2][1] == board[4][1]);
        boolean middleColumn = (board[0][5] != ' ' && board[0][5] == board[2][5] && board[2][5] == board[4][5]);
        boolean rightColumn = (board[0][9] != ' ' && board[0][9] == board[2][9] && board[2][9] == board[4][9]);

        boolean diagonal1 = (board[0][1] != ' ' && board[0][1] == board[2][5] && board[2][5] == board[4][9]);
        boolean diagonal2 = (board[4][1] != ' ' && board[4][1] == board[2][5] && board[2][5] == board[0][9]);

        if (topRow || middleRow || bottomRow || leftColumn || middleColumn || rightColumn || diagonal1 || diagonal2)
            return true;
        return false;
    }
}