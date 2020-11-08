package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PiecesTest {

    @Test
    public void correctIsAdvanced(){
        assertFalse(new Pawn(Color.BLACK).isAdvanced(new Coordinate(7,0), new Coordinate(6, 1)));
        assertFalse(new Pawn(Color.WHITE).isAdvanced(new Coordinate(6,1), new Coordinate(7, 0)));
    }
    @Test
    public void incorrectIsAdvanced(){
        assertTrue(new Pawn(Color.WHITE).isAdvanced(new Coordinate(7,0), new Coordinate(6, 1)));
        assertTrue(new Pawn(Color.BLACK).isAdvanced(new Coordinate(6,1), new Coordinate(7, 0)));
    }
}
