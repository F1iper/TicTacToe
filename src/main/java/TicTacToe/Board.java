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

    public boolean placePiece(int pos, String user) throws Exception {
        while (true) {
            char symbol = ' ';
            if (fieldIsNotEmpty(pos))
                return false;
            if (user.equals(PLAYER))
                symbol = 'x';
            else if (user.equals(PC))
                symbol = 'o';

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
                    throw new Exception("Unknown player.");
            }
            return true;
        }
    }

    private boolean fieldIsNotEmpty(int pos){
        int row = (pos - 1) / 3;
        int col = pos % 3 - 1;

        if (pos == 3 || pos == 6)
            return board[row * 2][col * (-9)] != ' ';
        else if (pos == 9)
            return board[row * 2][col * (-8)] != ' ';
        else return board[row * 2][col * 4 + 1] != ' ';
    }

    public char[][] getBoard() {
        return board;
    }
}