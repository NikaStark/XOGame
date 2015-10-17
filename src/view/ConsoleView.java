package view;

import model.GameBoard;
import model.Players;

import java.util.Scanner;

public class ConsoleView {

    public static int getCoordinateX() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input X: ");
        return in.nextInt();
    }

    public static int getCoordinateY() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input Y: ");
        return in.nextInt();
    }

    public static void sayGetMove(final char figure) {
        System.out.format("Input %c coordinate.", figure);
        System.out.println();
    }

    public static void sayAboutError() {
        System.out.println("Your coordinate is wrong, try again.");
    }

    public void showBoard(GameBoard gameBoard) {
        System.out.println("+---+---+---+");
        for (int i = 0; i < GameBoard.NUMBER_OF_CELL; i++) {
            System.out.print("| ");
            for (int j = 0; j < GameBoard.NUMBER_OF_CELL; j++) {
                System.out.print(gameBoard.getBoard(i, j) + " | ");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }

    public void showPlayers(Players players) {
        System.out.print(players.firstPlayerName + " -> " + Players.figureOfFirstPlayer + " | ");
        System.out.println(Players.figureOfSecondPlayer + " <- " + players.secondPlayerName);
    }

    public void showWinnerPlayer(String winnerPlayer) {
        System.out.println("Congratulate " + winnerPlayer + ", you won!");
    }

}
