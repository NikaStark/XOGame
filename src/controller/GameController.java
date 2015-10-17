package controller;

import helpers.Helper;
import model.GameBoard;
import model.Players;
import view.ConsoleView;

public class GameController {

    final GameBoard gameBoard = new GameBoard();

    final Players players = new Players("Alex", "Denis");

    public void startConsoleGame() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.showPlayers(this.players);
        while (!checkWinner()) {
            setMove();
            consoleView.showBoard(this.gameBoard);
        }
        if (getCurrentFigure() == Players.figureOfFirstPlayer) {
            consoleView.showWinnerPlayer(this.players.firstPlayerName);
        } else {
            consoleView.showWinnerPlayer(this.players.secondPlayerName);
        }
    }

    private void setMove() {
        char figure = getCurrentFigure();
        int x, y;
        do {
            ConsoleView.sayGetMove(figure);
            x = ConsoleView.getCoordinateX();
            y = ConsoleView.getCoordinateY();
        } while (!checkMove(x, y));
        this.gameBoard.setFigureToXY(x, y, figure);
    }

    public char getCurrentFigure() {
        int countOfFirstFigure = 0, countOfSecondFigure = 0;
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            for (int j = 0; j < GameBoard.NUMBER_OF_CELL; j++) {
                switch (this.gameBoard.getBoard(i, j)) {
                    case Players.figureOfFirstPlayer:
                        countOfFirstFigure++;
                        break;
                    case Players.figureOfSecondPlayer:
                        countOfSecondFigure++;
                        break;
                }
            }
        }
        if (countOfFirstFigure == countOfSecondFigure) {
            return Players.figureOfFirstPlayer;
        } else {
            return Players.figureOfSecondPlayer;
        }
    }

    private boolean checkMove(final int x, final int y) {
        if (Helper.checkXCoordinate(x) || Helper.checkYCoordinate(y) || (this.gameBoard.getBoard(x, y) != '\u0000')) {
            ConsoleView.sayAboutError();
            return false;
        } else {
            return true;
        }
    }

    public boolean checkWinner() {
        return checkVertical() || checkHorizontal() || checkRightDiagonal() || checkLeftDiagonal();
    }

    private boolean checkVertical() {
        int count;
        for (int j = 0; j < GameBoard.NUMBER_OF_CELL; j++) {
            count = 0;
            for (int i = 0; i < GameBoard.NUMBER_OF_CELL - 1; i++) {
                if (this.gameBoard.getBoard(i, j) == this.gameBoard.getBoard(i + 1, j) && this.gameBoard.getBoard(i, j) != '\u0000') {
                    count++;
                } else {
                    break;
                }
            }
            if (count == GameBoard.NUMBER_OF_CELL - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal() {
        int count;
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            count = 0;
            for (int j = 0; j < GameBoard.NUMBER_OF_CELL - 1; j++) {
                if (this.gameBoard.getBoard(i, j) == this.gameBoard.getBoard(i, j + 1) && this.gameBoard.getBoard(i, j) != '\u0000') {
                    count++;
                } else {
                    break;
                }
            }
            if (count == GameBoard.NUMBER_OF_CELL - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRightDiagonal() {
        for (int i = 0; i < (GameBoard.NUMBER_OF_CELL - 1); i++) {
            if (this.gameBoard.getBoard(GameBoard.NUMBER_OF_CELL - i - 1, i) != this.gameBoard.getBoard(GameBoard.NUMBER_OF_CELL - i - 2, i + 1)
                    || this.gameBoard.getBoard(GameBoard.NUMBER_OF_CELL - i - 1, i) == '\u0000') {
                return false;
            }
        }
        return true;
    }

    private boolean checkLeftDiagonal() {
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL - 1; i++) {
            if (this.gameBoard.getBoard(i, i) != this.gameBoard.getBoard(i + 1, i + 1) || this.gameBoard.getBoard(i, i) == '\u0000') {
                return false;
            }
        }
        return true;
    }
}
