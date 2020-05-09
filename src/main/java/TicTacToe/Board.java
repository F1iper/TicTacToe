package TicTacToe;

public class Board {
    public static final String PLAYER = "player";
    public static final String PC = "pc";
    private char[][] board = {
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
            {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
            {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}};

    public boolean gameOver() {

        boolean topRow = (board[0][1] != ' ' && board[0][1] == board[0][5] && board[0][5] == board[0][9]);
        boolean middleRow = (board[2][1] != ' ' && board[2][1] == board[2][5] && board[2][5] == board[2][9]);
        boolean bottomRow = (board[4][1] != ' ' && board[4][1] == board[4][5] && board[4][5] == board[4][9]);

        boolean leftColumn = (board[0][1] != ' ' && board[0][1] == board[2][1] && board[2][1] == board[4][1]);
        boolean middleColumn = (board[0][5] != ' ' && board[0][5] == board[2][5] && board[2][5] == board[4][5]);
        boolean rightColumn = (board[0][9] != ' ' && board[0][9] == board[2][9] && board[2][9] == board[4][9]);

        boolean diagonal1 = (board[0][1] != ' ' && board[0][1] == board[2][5] && board[2][5] == board[4][9]);
        boolean diagonal2 = (board[4][1] != ' ' && board[4][1] == board[2][5] && board[2][5] == board[0][9]);

        return topRow || middleRow || bottomRow || leftColumn || middleColumn
                || rightColumn || diagonal1 || diagonal2;
    }

    public boolean placePiece(int pos, String user) {
        char symbol = ' ';
        if (fieldIsNotEmpty(pos))
            return false;
        if (user.equals(PLAYER))
            symbol = 'x';
        else if (user.equals(PC))
            symbol = 'o';

        while (true) {
            switch (pos) {
                case 1:
                    board[0][1] = symbol;
                    break;
                case 2:
                    board[0][5] = symbol;
                    break;
                case 3:
                    board[0][9] = symbol;
                    break;
                case 4:
                    board[2][1] = symbol;
                    break;
                case 5:
                    board[2][5] = symbol;
                    break;
                case 6:
                    board[2][9] = symbol;
                    break;
                case 7:
                    board[4][1] = symbol;
                    break;
                case 8:
                    board[4][5] = symbol;
                    break;
                case 9:
                    board[4][9] = symbol;
                    break;
                default:
                    return false;
            }
            break;
        }
        return true;
    }

    private boolean fieldIsNotEmpty(int pos) {
        int row = (pos - 1) / 3;
        int col = pos % 3 - 1;

        if (pos == 3 || pos == 6 || pos == 9)
            return board[row * 2][col * (-9)] != ' ';
        else if (pos == 1 || pos == 2 || pos == 4 || pos == 5 || pos == 7 || pos == 8)
            return board[row * 2][col * 4 + 1] != ' ';
        return false;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean placePiece(int x, int y, String player) {
        int pos = y * 3 + x + 1;
        return placePiece(pos, player);
    }


    public char getPiece(int col, int row) {
        int pos = row * 3 + col + 1;
        switch (pos) {
            case 1:
                return board[0][1];
            case 2:
                return board[0][5];
            case 3:
                return board[0][9];
            case 4:
                return board[2][1];
            case 5:
                return board[2][5];
            case 6:
                return board[2][9];
            case 7:
                return board[4][1];
            case 8:
                return board[4][5];
            case 9:
                return board[4][9];
            default:
                return ' ';
        }
    }
}