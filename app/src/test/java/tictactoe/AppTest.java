package tictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AppTest {

    static App tictactoe;

    @BeforeAll
    static void before() {
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
}
