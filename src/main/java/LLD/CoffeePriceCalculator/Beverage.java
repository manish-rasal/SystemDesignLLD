package main.java.LLD.CoffeePriceCalculator;

public abstract class Beverage {
    String beverageName = "";

    String getBeverageName() {
        return beverageName;
    }

    abstract int getBeveragePrice();
}
