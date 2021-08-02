package OOP03_Encapsulation.e3_ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        String[] firstLine = scanner.nextLine().split(";");

        for (int i = 0; i < firstLine.length; i++) {
            String name = firstLine[i].split("=")[0];
            double money = Double.parseDouble(firstLine[i].split("=")[1]);
            Person person = new Person(name, money);

            people.add(person);
        }
        String[] secondLine = scanner.nextLine().split(";");

        for (int i = 0; i < secondLine.length; i++) {
            String name = secondLine[i].split("=")[0];
            double cost = Double.parseDouble(secondLine[i].split("=")[1]);
            Product product = new Product(name, cost);

            products.add(product);
        }

        String input = "";
        while (!"END".equals(input = scanner.nextLine())){
            String name = input.split("\\s+")[0];
            String product = input.split("\\s+")[1];

            try{
                for (Person prs : people) {
                    if(prs.getName().equals(name)){
                        for (Product prd : products) {
                            if(prd.getName().equals(product)){
                                prs.buyProduct(prd);
                                break;
                            }
                        }
                        break;
                    }
                }
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        for (Person person : people) {

            String printProducts = "";

            if(person.getProducts().size() > 0){
               printProducts =  person.getProducts().toString().replaceAll("\\[","").replaceAll("]","");
            }else {
                printProducts = "Nothing bought";
            }

            System.out.println(person.getName() + " - " + printProducts);
        }
    }
}
