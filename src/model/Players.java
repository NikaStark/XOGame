package model;

public class Players {

    public static final char figureOfFirstPlayer = 'X';

    public String firstPlayerName;

    public static final char figureOfSecondPlayer = 'O';

    public String secondPlayerName;

    public Players(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

}
