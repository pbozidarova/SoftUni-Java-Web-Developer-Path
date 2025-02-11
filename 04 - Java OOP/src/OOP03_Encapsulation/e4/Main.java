package OOP03_Encapsulation.e4;

import OOP03_Encapsulation.e4.pizza.Dough;
import OOP03_Encapsulation.e4.pizza.Topping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = null;

        try {
            scanner.next();
            String name = scanner.next();
            int toppingsCount = scanner.nextInt();
            scanner.next();

            pizza = new Pizza(name, toppingsCount);
            Dough dough = new Dough(scanner.next(), scanner.next(), scanner.nextDouble());
            pizza.setDough(dough);

            scanner.nextLine();

            String input = scanner.nextLine();

            while (!input.equals("END") && pizza != null) {
                String[] tokens = input.split("\\s+");

                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);


                input = scanner.nextLine();
            }
            System.out.println(pizza.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
