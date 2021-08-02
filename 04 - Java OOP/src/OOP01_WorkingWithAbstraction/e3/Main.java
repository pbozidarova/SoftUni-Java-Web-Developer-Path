package OOP01_WorkingWithAbstraction.e3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String rank = sc.nextLine();
        String suit = sc.nextLine();
        int power = CardRank.valueOf(rank).getValue() + CardSuit.valueOf(suit).getValue();

        System.out.printf("Card name: %s of %s; Card power: %d",
                rank,
                suit,
                power);

    }
}
