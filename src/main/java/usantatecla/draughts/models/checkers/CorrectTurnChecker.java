package usantatecla.draughts.models.checkers;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;

public class CorrectTurnChecker extends Checker {
    private Game game;
    public CorrectTurnChecker(Game game){
        this.game = game;
    }

    @Override
    public Error check(int pair, Coordinate... coordinates) {
        if(this.game.getOppositeTurnColor() == this.game.getColor(coordinates[pair]))
            return Error.OPPOSITE_PIECE;
        return checkNext(pair, coordinates);
    }
}
