package OOP03_Encapsulation.e3_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public Person(String name, double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }


    public void buyProduct(Product product){
        if(this.getMoney() >= product.getCost()){
            this.money = this.getMoney() - product.getCost();
            products.add(product);
            System.out.println(this.getName() + " bought " + product.getName());

        } else {
            throw new IllegalArgumentException(this.getName() + " can't afford " + product.getName());
        }
    }
    private double getMoney(){
        return this.money;
    }

    public String getName(){
        return this.name;
    }


}
