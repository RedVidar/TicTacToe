
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testIsDraw() {
        Board board = new Board();

        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'O');
        board.makeMove(2, 1, 'X');


        assertFalse(board.isDraw(), "Board is not full, so it should not be a draw");

        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'O');
        board.makeMove(2, 1, 'X');
        board.makeMove(2, 2, 'O');

        assertTrue(board.isDraw(), "Board is full, so it should be a draw");
    }

    @Test
    public void testIsWinner() {
        Board board = new Board();

        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'O');
        board.makeMove(2, 1, 'X');


        assertTrue(board.checkWin('X'), "PLayer X Wins");

        board.makeMove(0, 0, 'O');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'O');
        board.makeMove(2, 1, 'X');
        board.makeMove(2, 2, 'O');

        assertTrue(board.checkWin('O'), "PLayer O Wins");
    }
}