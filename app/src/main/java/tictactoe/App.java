package tictactoe;

public class App {

    private Character[][] board = new Character[3][3];

    public void play(int x, int y) {
        if (x < 0 || x > 2) {
            throw new RuntimeException("Invalid mark outside the board");
        }
        if (y < 0 || y > 2) {
            throw new RuntimeException("Invalid mark outside the board");
        }
        if (board[x][y] != null) {
            throw new RuntimeException("Invalid move, this spot is occupied");
        }
        board[x][y] = 'X';
    }
}
