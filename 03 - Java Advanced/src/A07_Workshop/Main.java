package A07_Workshop;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        workshop1();

        Scanner scanner = new Scanner(System.in);

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(12);
        list.addFirst(42);
        list.addFirst(13);


        Integer[] arr = list.toArray();


        list.forEach(System.out::println);

        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }

        list.get(0);
    }



    private static void workshop1() {
        SmartArray<CustomStack> someCrazyList = new SmartArray();
        CustomStack customStack = new CustomStack();
        customStack.push(123);
        customStack.push(23);
        customStack.push(322222);


        someCrazyList.add(customStack);

        CustomStack customStack2 = new CustomStack();
        customStack2.push(4);
        customStack2.push(5);
        customStack2.push(6);

        someCrazyList.add(customStack2);

        someCrazyList.forEach(cs -> {
            cs.forEach(System.out::println);
        });
    }
}
