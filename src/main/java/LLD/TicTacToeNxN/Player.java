package main.java.LLD.TicTacToeNxN;

import java.util.Objects;

public class Player {
    private String playerName;
    private int playerId;
    private String email;
    private int ranking;
    private char playerSymbol;

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getEmail() {
        return email;
    }

    public int getRanking() {
        return ranking;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId && ranking == player.ranking && playerSymbol == player.playerSymbol && Objects.equals(playerName, player.playerName) && Objects.equals(email, player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, playerId, email, ranking, playerSymbol);
    }
}
