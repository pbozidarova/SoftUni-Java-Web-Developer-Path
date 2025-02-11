package OOP03_Encapsulation.e4;

import OOP03_Encapsulation.e4.pizza.Dough;
import OOP03_Encapsulation.e4.pizza.Topping;
import OOP03_Encapsulation.e4.pizza.Validator;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.dough = null;
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    private void setToppings(int numberOfToppings) {
        Validator.validateNumberOfToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        Validator.validatePizzaName(name);
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() < this.numberOfToppings) {
            this.toppings.add(topping);
        }
    }

    public double getOverallCalories() {
        return this.dough.calculateCalories() +
                this.toppings
                        .stream()
                        .mapToDouble(Topping::calculateCalories)
                        .sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", getName(), getOverallCalories());
    }
}
