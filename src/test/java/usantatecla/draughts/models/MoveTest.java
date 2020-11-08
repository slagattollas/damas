package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MoveTest {

    @Test
    public void correctMoveTwoSpaceDamaTest(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  N     ",
                "        ",
                "        ",
                "        ",
                "        "
        };
        String[] rowsResult = {
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "    N   ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        assertNull(game.move(
                new Coordinate(3,2),
                new Coordinate(5, 4)
        ));
        Game result = new GameBuilder().color(Color.WHITE).board(rowsResult).build();
        assertEquals(game, result);
    }
    @Test
    public void correctMoveEatDamaTest(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  N     ",
                "   B    ",
                "        ",
                "        ",
                "        "
        };
        String[] rowsResult = {
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "    N   ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        assertNull(game.move(
                new Coordinate(3,2),
                new Coordinate(5, 4)
        ));
        Game result = new GameBuilder().color(Color.WHITE).board(rowsResult).build();
        assertEquals(game, result);
    }
    @Test
    public void correctMovePawnTest(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  n     ",
                "        ",
                "        ",
                "        ",
                "        "
        };
        String[] rowsResult = {
                "        ",
                "        ",
                "        ",
                "        ",
                "   n    ",
                "        ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        assertNull(game.move(
                new Coordinate(3,2),
                new Coordinate(4, 3)
        ));
        Game result = new GameBuilder().color(Color.WHITE).board(rowsResult).build();
        assertEquals(game, result);
    }
    @Test
    public void correctMoveEatPawnTest(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  n     ",
                "   b    ",
                "        ",
                "        ",
                "        "
        };
        String[] rowsResult = {
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "    n   ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        assertNull(game.move(
                new Coordinate(3,2),
                new Coordinate(5, 4)
        ));
        Game result = new GameBuilder().color(Color.WHITE).board(rowsResult).build();
        assertEquals(game, result);
    }
    @Test
    public void incorrectMoveEmptyOrigin(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  N     ",
                "        ",
                "        ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        assertEquals(Error.EMPTY_ORIGIN,game.move(
                new Coordinate(4,3),
                new Coordinate(5, 4)
        ));
    }
    @Test
    public void incorrectMoveOppositePiece(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  N     ",
                "        ",
                "        ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.WHITE).board(rows).build();
        assertEquals(Error.OPPOSITE_PIECE,game.move(
                new Coordinate(3,2),
                new Coordinate(5, 4)
        ));
    }
    @Test
    public void incorrectMoveNotEmptyTarget(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  N     ",
                "        ",
                "    B   ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        assertEquals(Error.NOT_EMPTY_TARGET,game.move(
                new Coordinate(3,2),
                new Coordinate(5, 4)
        ));
    }
    @Test
    public void incorrectMoveTooMuchJumps(){
        String[] rows = {
                "        ",
                "        ",
                "        ",
                "  N     ",
                "        ",
                "        ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        assertEquals(Error.TOO_MUCH_JUMPS,game.move(
                new Coordinate(3,2),
                new Coordinate(5, 4),
                new Coordinate(7, 2)
        ));

    }
}
