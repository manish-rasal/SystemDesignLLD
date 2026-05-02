package main.java.LLD.SnakeAndLadder;

public class Dice {
    private int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int rollDice() {
        return ((int) (Math.random() * (6 * numberOfDice - numberOfDice))) + 1;
    }
}
