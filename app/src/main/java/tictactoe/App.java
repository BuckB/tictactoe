package tictactoe;

public class App {

    public void play(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("Invalid mark outside the board");
        }
        if (y < 1 || y > 3) {
            throw new RuntimeException("Invalid mark outside the board");
        }
    }
}
