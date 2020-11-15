package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {
    @Test
    public void IsWithinTest(){
        String WithinCoordinate = "62";
        String NotWithinCoordinate = "92";
        assertEquals(new Coordinate(5,1),Coordinate.getInstance(WithinCoordinate));
        assertNull(Coordinate.getInstance(NotWithinCoordinate));
    }
    @Test
    public void getDirectionTest(){
        assertEquals(Direction.NE,new Coordinate(4,1).getDirection(new Coordinate(5,2)));
        assertEquals(Direction.SE,new Coordinate(5,1).getDirection(new Coordinate(4,2)));
        assertEquals(Direction.NW,new Coordinate(4,2).getDirection(new Coordinate(5,1)));
        assertEquals(Direction.SW,new Coordinate(5,3).getDirection(new Coordinate(4,2)));
        assertNull(new Coordinate(4,3).getDirection(new Coordinate(4,3)));
    }
}
