package main.java.LLD.TicTacToeNxN;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.setPlayerId(1);
        p1.setPlayerName("Manish");
        p1.setPlayerSymbol('O');

        Player p2 = new Player();
        p2.setPlayerId(2);
        p2.setPlayerName("Max");
        p2.setPlayerSymbol('X');

        Player[] players = new Player[]{p1, p2};

        GameBoard gb = new GameBoard(3, players);
        gb.startGame();
    }
}
