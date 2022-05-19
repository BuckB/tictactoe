package tictactoe;

public class App {

    private Character[][] board = new Character[3][3];
    private char lastPlayer = '\0';

    public String play(int x, int y) {
        validateMove(x);
        validateMove(y);
        lastPlayer = nextPlayer();
        validateSpace(x, y, lastPlayer);
        if (isWin()) {
            return lastPlayer + " is the winner.";
        }
        return "No winner.";
    }

    public void validateMove(int position) {
        if (position < 0 || position > 2) {
            throw new RuntimeException("Invalid move outside the board");
        }
    }

    public void validateSpace(int x, int y, char lastPlayer) {
        if (board[x][y] != null) {
            throw new RuntimeException("Invalid move, this spot is occupied");
        }
        board[x][y] = lastPlayer;
    }

    public char nextPlayer() {
        return lastPlayer == 'X' ? 'O' : 'X';
    }

    public boolean isWin() {
        for (int index = 0; index < 3; index++) {
            if (board[index][0] == lastPlayer &&
                    board[index][1] == lastPlayer &&
                    board[index][2] == lastPlayer) {
                return true;
            }
        }
        return false;
    }
}
