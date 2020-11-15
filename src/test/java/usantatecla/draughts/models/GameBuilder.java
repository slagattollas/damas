package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameBuilder {

    private Color color;
    private List<String> rows;

    public GameBuilder() {
        this.color = null;
        this.rows = new ArrayList<String>();
    }

    public GameBuilder color(Color color){
        this.color = color;
        return this;
    }
    public GameBuilder board(String... rows){
        for (String row: rows) {
            if(Pattern.matches("[bBnN ]{8}", row)){
                this.rows.add(row);
            }
        }
        return this;
    }
    public Game build(){
        if(this.rows.size() == 0){
            return new Game();
        }
        Board board = new Board();
        Game game = new Game(board);
        this.changeColor(game, board);
        for (int i = 0; i < this.rows.size(); i++) {
            this.setBoard(board, i, this.rows.get(i));
        }
        return game;
    }
    public void setBoard(Board board, int index, String row){
        for (int j = 0; j < row.length(); j++) {
            Color color = this.getColor(row.charAt(j));
            if (color != null) {
                Piece piece = new Pawn(color);
                if (Character.isUpperCase(row.charAt(j)))
                    piece = new Draught(color);
                board.put(new Coordinate(index, j), piece);
            }
        }
    }
    private Color getColor(char character) {
        switch (character) {
            case 'b':
            case 'B':
                return Color.WHITE;
            case 'n':
            case 'N':
                return Color.BLACK;
            default:
                return null;
        }
    }
    private void changeColor(Game game, Board board) {
        if (this.color == Color.BLACK) {
            board.put(new Coordinate(5, 0), new Pawn(Color.WHITE));
            game.move(new Coordinate(5, 0), new Coordinate(4, 1));
            board.remove(new Coordinate(4, 1));
        }
    }
}
