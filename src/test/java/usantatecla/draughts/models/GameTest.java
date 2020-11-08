package usantatecla.draughts.models;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameTest {
    @Test
    public void testGameReset(){
        Game game = new Game();
        game.move(
                new Coordinate(5,6),
                new Coordinate(4,5)
        );
        game.reset();
        String[] rowsResult = {
            " n n n n",
            "n n n n ",
            " n n n n",
            "        ",
            "        ",
            "b b b b ",
            " b b b b",
            "b b b b "
        };
        Game result = new GameBuilder().color(Color.WHITE).board(rowsResult).build();
        assertEquals(game, result);
    }
    @Test
    public void testStartGameCorrect(){
        Game game = new Game();
        String[] rowsResult = {
            " n n n n",
            "n n n n ",
            " n n n n",
            "        ",
            "        ",
            "b b b b ",
            " b b b b",
            "b b b b "
        };
        Game result = new GameBuilder().color(Color.WHITE).board(rowsResult).build();
        assertEquals(game, result);
    }
    @Test
    public void testStartGameCIncorrect(){
        Game game = new Game();
        String[] rowsResult = {
            "n n n n ",
            " n n n n",
            "n n n n ",
            "        ",
            "        ",
            "b b b b ",
            " b b b b",
            "b b b b "
        };
        Game result = new GameBuilder().color(Color.WHITE).board(rowsResult).build();
        assertNotEquals(game, result);
    }
    @Test
    public void testGameCancel(){
        Game game = new Game();
        game.cancel();
        String[] rowsResult = {
            " n n n n",
            "n n n n ",
            " n n n n",
            "        ",
            "        ",
            "        ",
            "        ",
            "        "
        };
        Game result = new GameBuilder().color(Color.BLACK).board(rowsResult).build();
        assertEquals(game, result);
    }
}
