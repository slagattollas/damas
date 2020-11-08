package controllers;

import org.junit.Test;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.*;

import static org.junit.Assert.*;

public class PlayControllerTest {

    @Test
    public void PlayControllerMoveTest(){
        Game game = new GameBuilder().build();
        PlayController playController = new PlayController(game, new State());
        assertNull(playController.move(new Coordinate(5,0), new Coordinate(4,1)));
    }
    @Test
    public void PlayControllerCancelTest(){
        Game game = new GameBuilder().build();
        PlayController playController = new PlayController(game, new State());
        playController.cancel();
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
    @Test
    public void PlayControllerIsBlocked(){
        String[] rows = {
                "        ",
                "        ",
                " n      ",
                "b b     ",
                "   b    ",
                "        ",
                "        ",
                "        "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rows).build();
        PlayController playController = new PlayController(game, new State());
        assertTrue(playController.isBlocked());
    }
}
