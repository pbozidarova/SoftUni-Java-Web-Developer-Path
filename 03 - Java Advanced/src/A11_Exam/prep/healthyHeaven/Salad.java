package A11_Exam.prep.healthyHeaven;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        return this.products
                .stream()
                .mapToInt(Vegetable::getCalories)
                .sum();
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
        String.format("* Salad %s is %d calories and have %d products:",
                this.getName(),
                this.getTotalCalories(),
                this.getProductCount()
                ));

        sb.append(System.lineSeparator());

        for (Vegetable product : products) {
            sb.append(product.toString()).append(System.lineSeparator());
        }
        
        return sb.toString().trim();
    }
}
