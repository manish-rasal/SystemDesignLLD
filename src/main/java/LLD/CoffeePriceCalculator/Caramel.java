package main.java.LLD.CoffeePriceCalculator;

public class Caramel extends IngredientDecorator{

    Beverage beverage;

    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    String getBeverageName() {
        return beverage.getBeverageName() + " with Caramel";
    }

    @Override
    int getBeveragePrice() {
        return beverage.getBeveragePrice() + 3;
    }
}
