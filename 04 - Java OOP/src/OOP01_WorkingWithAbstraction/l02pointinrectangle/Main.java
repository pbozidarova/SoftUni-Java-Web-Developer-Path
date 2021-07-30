package OOP01_WorkingWithAbstraction.l02pointinrectangle;

import OOP01_WorkingWithAbstraction.l02pointinrectangle.Point;
import OOP01_WorkingWithAbstraction.l02pointinrectangle.Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeft = new Point(rectangleCoords[0], rectangleCoords[1]);
        Point topRight = new Point(rectangleCoords[2], rectangleCoords[3]);

        Rectangle rect = new Rectangle(bottomLeft, topRight);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            int[] pointCoords = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point current = new Point(pointCoords[0], pointCoords[1]);

            System.out.println(rect.contains(current));
        }
    }
}
