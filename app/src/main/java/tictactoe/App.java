package tictactoe;

public class App {

    private Character[][] board = {
            { '\0', '\0', '\0' },
            { '\0', '\0', '\0' },
            { '\0', '\0', '\0' }
    };
    private char lastPlayer = '\0';
    private int playCounter = 0;
    private static int winCondition = 3;

    public String play(int x, int y) {
        validateMove(x);
        validateMove(y);
        lastPlayer = nextPlayer();
        validateSpace(x, y, lastPlayer);
        if (playCounter > 4 && isWin()) {
            return lastPlayer + " is the winner.";
        } else if (isDraw()) {
            return "It's a draw.";
        }
        return "No winner.";
    }

    private void validateMove(int position) {
        if (position < 0 || position > 2) {
            throw new RuntimeException("Invalid move outside the board");
        }
    }

    private void validateSpace(int x, int y, char lastPlayer) {
        if (board[x][y] != '\0') {
            throw new RuntimeException("Invalid move, this spot is occupied");
        }
        board[x][y] = lastPlayer;
        playCounter++;
    }

    public char nextPlayer() {
        return lastPlayer == 'X' ? 'O' : 'X';
    }

    private boolean isWin() {
        if (verifyDiagonals())
            return true;
        if (verifyLines())
            return true;
        if (verifyColumns())
            return true;
        return false;
    }

    private boolean verifyLines() {
        for (int index = 0; index < winCondition; index++) {
            if (board[index][0] + board[index][1] + board[index][2] == lastPlayer * winCondition) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyColumns() {
        for (int index = 0; index < winCondition; index++) {
            if (board[0][index] + board[1][index] + board[2][index] == lastPlayer * winCondition) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyDiagonals() {
        if (board[0][0] + board[1][1] + board[2][2] == lastPlayer * winCondition) {
            return true;
        }
        if (board[0][2] + board[1][1] + board[2][0] == lastPlayer * winCondition) {
            return true;
        }
        return false;
    }

    private boolean isDraw() {
        if (playCounter == 9)
            return true;
        return false;
    }

    public boolean isDefeatPossible() {
        return true;
    }
}
