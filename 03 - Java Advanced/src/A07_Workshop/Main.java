package A07_Workshop;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
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
