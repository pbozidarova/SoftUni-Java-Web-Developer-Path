package OOP01_WorkingWithAbstraction.l01rhombusofstars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int maxWidth = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < maxWidth; i++) {
            printRow(maxWidth, i);
        }

        System.out.println(repeatString("* ", maxWidth -1 ) + "*");
        for (int i = maxWidth -1; i > 0; i--) {
            printRow(maxWidth, i);
        }
    }

    private static void printRow(int maxWidth, int row) {
        System.out.print(repeatString(" ", maxWidth - row));
        System.out.print(repeatString("* ", row));
        System.out.println();
    }

    private static String repeatString(String sequence, int times){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < times; i++) {
            builder.append(sequence);
        }

        return builder.toString();
    }
}
