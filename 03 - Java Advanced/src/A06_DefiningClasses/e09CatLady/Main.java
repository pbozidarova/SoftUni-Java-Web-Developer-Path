package A06_DefiningClasses.e09CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        HashMap<String, Cat> cats = new HashMap();

        while (!data.equals("End")){

            String[] tokens = data.split("\\s+");

            String breed = tokens[0];
            String name = tokens[1];
            double specialData = Double.parseDouble(tokens[2]);

            cats.putIfAbsent(name, new Cat(name, breed, specialData));

            data = scanner.nextLine();
        }

        String catName = scanner.nextLine();
        Cat cat = cats.get(catName);

        System.out.println(cat.toString());

    }
}
