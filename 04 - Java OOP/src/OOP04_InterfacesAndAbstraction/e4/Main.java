package OOP04_InterfacesAndAbstraction.e4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();
        String input = scanner.nextLine();

        while (n-- > 0) {
            if (input.split("\\s+").length == 4) {
                Citizen citizen = new Citizen(
                        input.split("\\s+")[0],
                        Integer.parseInt(input.split("\\s+")[1]),
                        input.split("\\s+")[2],
                        input.split("\\s+")[3]
                );
                citizens.add(citizen);
            } else if (input.split("\\s+").length == 3) {
                Rebel rebel = new Rebel(
                        input.split("\\s+")[0],
                        Integer.parseInt(input.split("\\s+")[1]),
                        input.split("\\s+")[2]
                );
                rebels.add(rebel);
            }
            input = scanner.nextLine();
        }

        while (!"End".equals(input)) {
            for (Citizen citizen : citizens) {
                if (input.equals(citizen.getName()))       citizen.buyFood();
            }
            for (Rebel rebel : rebels) {
                if (input.equals(rebel.getName()))         rebel.buyFood();
            }

            input = scanner.nextLine();
        }

        int foodRes = 0;

        for (Rebel rebel : rebels) {
            foodRes += rebel.getFood();
        }
        for (Citizen citizen : citizens) {
            foodRes += citizen.getFood();
        }

        System.out.println(foodRes);

    }
}
