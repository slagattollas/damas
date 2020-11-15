package controllers;

import org.junit.Test;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;

import static org.junit.Assert.assertEquals;

public class ResumeControllerTest {
    @Test
    public void ResumeTest(){
        String[] rowsResult = {
                "n n n n ",
                " n n n n",
                "n n n n ",
                "        ",
                " b      ",
                "  b b b ",
                " b b b b",
                "b b b b "
        };
        Game game = new GameBuilder().color(Color.BLACK).board(rowsResult).build();
        ResumeController resumeController = new ResumeController(game, new State());
        resumeController.reset();
        Game resultGame = new GameBuilder().build();
        assertEquals(game, resultGame);
    }
}
