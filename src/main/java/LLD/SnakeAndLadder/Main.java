package main.java.LLD.SnakeAndLadder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Player p1 = new Player("Max", 1);
        Player p2 = new Player("Joe", 2);
        Queue<Player> players = new LinkedList<>();
        players.offer(p1);
        players.offer(p2);
        Jumper snake1 = new Jumper(10, 2);
        Jumper snake2 = new Jumper(99, 12);

        List<Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);

        Jumper ladder1 = new Jumper(2, 25);
        Jumper ladder2 = new Jumper(40, 89);
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);

        HashMap<String, Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Max", 0);
        playersCurrentPosition.put("Joe", 0);
        GameBoard gb = new GameBoard(dice, players, snakes, ladders, playersCurrentPosition, 100);
        gb.startGame();
    }
}
