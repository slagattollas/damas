package usantatecla.draughts.utils;

public class Coordinate {
    protected int row;
    protected int column;
    public Coordinate() {
    }
    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return this.row;
    }
    public boolean isBlack() {
        return (this.row + this.column) % 2 != 0;
    }
    public int getColumn() {
        return this.column;
    }
    public Direction getDirection(Coordinate coordinate) {
        assert coordinate != null;
        Coordinate substract = coordinate.substract(this);
        for (Direction direction : Direction.values())
            if (direction.isOnDirection(substract))
                return direction;
        return null;
    }
    public boolean isOnDiagonal(Coordinate coordinate) {
        return this.getDirection(coordinate) != null;
    }
    public int getDiagonalDistance(Coordinate coordinate) {
        assert this.isOnDiagonal(coordinate);
        return Math.abs(this.substract(coordinate).getRow());
    }
    public usantatecla.draughts.models.Coordinate substract(Coordinate coordinate) {
        return new usantatecla.draughts.models.Coordinate(this.row - coordinate.row, this.column - coordinate.column);
    }
    public Coordinate addition(Coordinate thisCoordinate, Coordinate coordinate){
        return new usantatecla.draughts.models.Coordinate(thisCoordinate.row + coordinate.row, thisCoordinate.column + coordinate.column);
    }
}
