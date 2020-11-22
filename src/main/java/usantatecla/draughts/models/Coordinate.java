package usantatecla.draughts.models;

import usantatecla.draughts.utils.Direction;

import java.util.ArrayList;
import java.util.List;

public class Coordinate extends usantatecla.draughts.utils.Coordinate{

    public static final int LOWER_LIMIT = 0;
    public static final int UPPER_LIMIT = 7;
    public static final int DIMENSION = UPPER_LIMIT + 1;

    public Coordinate(){
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    public static Coordinate getInstance(String format) {
        assert format != null;
        try {
            int value = Integer.parseInt(format);
            int row = value / 10 - 1;
            int column = value % 10 - 1;
            Coordinate coordinate = new Coordinate(row, column);
            if (!coordinate.isWithIn())
                return null;
            return coordinate;
        } catch (Exception ex) {
            return null;
        }
    }
    private boolean isWithIn() {
        return Coordinate.LOWER_LIMIT <= row && row <= Coordinate.UPPER_LIMIT
                && Coordinate.LOWER_LIMIT <= column && column <= Coordinate.UPPER_LIMIT;
    }
    List<Coordinate> getBetweenDiagonalCoordinates(Coordinate coordinate) {
        assert this.isOnDiagonal(coordinate);
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        final Direction direction = this.getDirection(coordinate);
        Coordinate cursor = (Coordinate) super.addition(this, direction.getDistanceCoordinate(1));
        while (!cursor.equals(coordinate)) {
            coordinates.add(cursor);
            cursor = (Coordinate) super.addition(cursor, direction.getDistanceCoordinate(1));
        }
        return coordinates;
    }
    List<Coordinate> getDiagonalCoordinates(int level) {
        List<Coordinate> diagonalCoordinates = new ArrayList<Coordinate>();
        for (Direction direction : Direction.values()) {
            Coordinate diagonalCoordinate = (Coordinate) super.addition(this, direction.getDistanceCoordinate(level));
            if (diagonalCoordinate != null && diagonalCoordinate.isWithIn())
                diagonalCoordinates.add(diagonalCoordinate);
        }
        return diagonalCoordinates;
    }
    public boolean isLast() {
        return this.row == Coordinate.UPPER_LIMIT;
    }

    public boolean isFirst() {
        return this.row == Coordinate.LOWER_LIMIT;
    }

    public static int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

}