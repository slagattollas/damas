package usantatecla.draughts.models.checkers;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;

public abstract class Checker {
    private Checker next;

    public Checker linkWith(Checker next){
        this.next = next;
        return next;
    }
    public abstract Error check(int pair, Coordinate... coordinates);
    protected Error checkNext(int pair, Coordinate... coordinates) {
        if (next == null) {
            return null;
        }
        return next.check(pair, coordinates);
    }
}
