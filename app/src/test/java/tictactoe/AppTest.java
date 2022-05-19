package tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        tictactoe.validateSpace(0, 0, 'X');
        tictactoe.validateSpace(1, 0, 'O');
        tictactoe.validateSpace(0, 1, 'X');
        tictactoe.validateSpace(2, 0, 'O');
        String actual = tictactoe.play(0, 2);
        assertEquals("X is the winner.", actual);
    }
}
