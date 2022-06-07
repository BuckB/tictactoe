package tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    static App tictactoe;

    @BeforeEach
    public void before() {
        tictactoe = new App();
    }

    @Test
    void whenMoveOutsideXAxisThenThrowsRuntimeException() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> tictactoe.play(5, 2));
        assertEquals("Invalid move outside the board", ex.getMessage());
    }

    @Test
    void whenMoveOutsideYAxisThenThrowsRuntimeException() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> tictactoe.play(2,5));
        assertEquals("Invalid move outside the board", ex.getMessage());
    }

    @Test
    void whenMoveOnOccupiedSpaceThenThrowsRuntimeException() {
        tictactoe.play(1, 1);
        RuntimeException ex = assertThrows(RuntimeException.class, () -> tictactoe.play(1, 1));
        assertEquals("Invalid move, this spot is occupied", ex.getMessage());
    }

    @Test
    void givenFirstTurnWhenNextPlayerThenX() {
        assertEquals('X', tictactoe.nextPlayer());
    }

    @Test
    void givenLastTurnWasXWhenNextPlayerThenO() {
        tictactoe.play(1, 1);
        assertEquals('O', tictactoe.nextPlayer());
    }

    @Test
    void whenPlayThenNoWinner() {
        String actual = tictactoe.play(1,1);
        assertEquals("No winner.", actual);
    }

    @Test
    void whenPlayAndHorizontalLineThenWinner() {
        tictactoe.play(0, 0);
        tictactoe.play(1, 0);
        tictactoe.play(0, 1);
        tictactoe.play(2, 0);
        String actual = tictactoe.play(0, 2);
        assertEquals("X is the winner.", actual);
    }

    @Test
    void whenPlayAndVerticalLineThenWinner() {
        tictactoe.play(0, 0);
        tictactoe.play(1, 1);
        tictactoe.play(1, 0);
        tictactoe.play(2, 1);
        String actual = tictactoe.play(2, 0);
        assertEquals("X is the winner.", actual);
    }

    @Test
    void whenPlayAndDiagonalLineThenWinner() {
        tictactoe.play(0, 0);
        tictactoe.play(1, 0);
        tictactoe.play(1, 1);
        tictactoe.play(2, 0);
        String actual = tictactoe.play(2, 2);
        assertEquals("X is the winner.", actual);
    }

    @Test
    void whenPlayAndReverseDiagonalLineThenWinner() {
        tictactoe.play(0, 2);
        tictactoe.play(1, 0);
        tictactoe.play(1, 1);
        tictactoe.play(0, 0);
        String actual = tictactoe.play(2, 0);
        assertEquals("X is the winner.", actual);
    }

    @Test
    void whenNoMovesLeftThenDraw() {
        tictactoe.play(1,1);
        tictactoe.play(0,0);
        tictactoe.play(0,2);
        tictactoe.play(2,0);
        tictactoe.play(1,0);
        tictactoe.play(1,2);
        tictactoe.play(0,1);
        tictactoe.play(2,1);
        String actual = tictactoe.play(2,2);
        assertEquals("It's a draw.", actual);
    }

    @Test
    void givenAiTurnCheckForLosingCondition() {
        tictactoe.play(0, 0);
        tictactoe.play(1, 1);
        tictactoe.play(0, 1);
        assertTrue(tictactoe.isDefeatPossible());
    }
}
