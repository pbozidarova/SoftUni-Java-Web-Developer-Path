package OOP02_Inheritance.e5_restaurant;

import java.math.BigDecimal;

public class Beverage extends Product {
    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {

        super(name, price);
        this.milliliters = milliliters;
    }

    public Double getMilliliters() {
        return this.milliliters;
    }
}
