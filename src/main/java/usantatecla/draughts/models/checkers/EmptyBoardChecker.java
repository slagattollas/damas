package usantatecla.draughts.models.checkers;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;

public class EmptyBoardChecker extends Checker {
    private Game game;
    public EmptyBoardChecker(Game game){
        this.game = game;
    }

    @Override
    public Error check(int pair, Coordinate... coordinates) {
        if(this.game.boardIsEmpty(coordinates[pair]))
            return Error.EMPTY_ORIGIN;
        if(!this.game.boardIsEmpty(coordinates[pair + 1]))
            return Error.NOT_EMPTY_TARGET;
        return checkNext(pair,coordinates);
    }
}
