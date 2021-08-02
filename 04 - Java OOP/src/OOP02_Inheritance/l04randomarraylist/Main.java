package OOP02_Inheritance.l04randomarraylist;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add("Pesho");
        randomArrayList.add(123);
        randomArrayList.add(new BigDecimal("1.24"));


        System.out.println(randomArrayList.getRandomElement());
    }
}
