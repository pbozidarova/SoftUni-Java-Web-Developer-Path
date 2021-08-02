package OOP03_Encapsulation.e2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Chicken chicken = new Chicken("Koko", 10);

        System.out.println(chicken.toString());
    }
}
