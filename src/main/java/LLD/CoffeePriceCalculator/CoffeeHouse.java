package main.java.LLD.CoffeePriceCalculator;

public class CoffeeHouse {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());

        System.out.println("After adding an ingredient");
        beverage = new Milk(beverage);
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());

        beverage = new Caramel(beverage);
        beverage = new Caramel(beverage);

        System.out.println("After decorating with double caramel");
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());
    }
}
