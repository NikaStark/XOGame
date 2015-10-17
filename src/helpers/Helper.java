package helpers;

import model.GameBoard;

public class Helper {

    public static boolean checkXCoordinate(final int x) {
        return (x < 0 || x > GameBoard.NUMBER_OF_CELL - 1);
    }

    public static boolean checkYCoordinate(final int y) {
        return (y < 0 || y > GameBoard.NUMBER_OF_CELL - 1);
    }

}
