package model;


public class GameBoard {

    public static final int NUMBER_OF_CELL = 3;

    private final char[][] board = new char[NUMBER_OF_CELL][NUMBER_OF_CELL];

    public void setFigureToXY(final int x, final int y, final char figure) {
        this.board[x][y] = figure;
    }

    public char getBoard(int x, int y) {
        return this.board[x][y];
    }
}
