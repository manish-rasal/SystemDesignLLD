package main.java.LLD.CoffeePriceCalculator;

public class Espresso extends Beverage {

    public Espresso() {
        beverageName = "Espresso";
    }

    @Override
    int getBeveragePrice() {
        return 10;
    }
}
