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
    void WhenMarkOutsideXAxisThenThrowRuntimeException() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> tictactoe.play(5,2));
        assertEquals("Invalid mark outside the board", ex.getMessage());
    }
}
