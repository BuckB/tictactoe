package tictactoe;

public class App {

    private Character[][] board = new Character[3][3];
    private char lastPlayer = '\0';

    public void play(int x, int y) {
        validateMove(x);
        validateMove(y);
        validateSpace(x, y);
        lastPlayer = nextPlayer();
    }

    public void validateMove(int position) {
        if (position < 0 || position > 2) {
            throw new RuntimeException("Invalid move outside the board");
        }
    }

    public void validateSpace(int x, int y) {
        if (board[x][y] != null) {
            throw new RuntimeException("Invalid move, this spot is occupied");
        }
        board[x][y] = 'X';
    }

    public char nextPlayer() {
        return lastPlayer == 'X' ? 'O' : 'X';
    }
}
