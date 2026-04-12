package main.java.LLD.CoffeePriceCalculator;

public class Cappuccino extends Beverage {

    public Cappuccino() {
        beverageName = "Cappuccino";
    }

    @Override
    int getBeveragePrice() {
        return 12;
    }
}
