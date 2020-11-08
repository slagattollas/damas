package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirectionTest {
    /*NE(1, 1),
    SE(-1, 1),
    SW(-1, -1),
    NW(1, -1);*/
    @Test
    public void correctDirectionTest(){
        assertTrue(Direction.NE.isOnDirection(new Coordinate(1,1)));
        assertTrue(Direction.SE.isOnDirection(new Coordinate(-2, 2)));
        assertTrue(Direction.SW.isOnDirection(new Coordinate(-3, -3)));
        assertTrue(Direction.NW.isOnDirection(new Coordinate(4, -4)));
    }
    @Test
    public void incorrectDirectionTest(){
        assertFalse(Direction.NE.isOnDirection(new Coordinate(-1,-1)));
        assertFalse(Direction.SE.isOnDirection(new Coordinate(2, 2)));
        assertFalse(Direction.SW.isOnDirection(new Coordinate(3, 3)));
        assertFalse(Direction.NW.isOnDirection(new Coordinate(-4, -4)));
    }
}
