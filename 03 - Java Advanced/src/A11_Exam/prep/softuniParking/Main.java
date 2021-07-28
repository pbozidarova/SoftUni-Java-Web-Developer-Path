package A11_Exam.prep.softuniParking;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Parking parking = new Parking(1);

        Car car = new Car("Skoda", "Fabia",65, "CC1856AA");
        Car car2 = new Car("Audi", "A3",110, "CO1856AA");

        System.out.println(car.toString());

        List<String> regNums = new ArrayList<>();
        regNums.add("1234");
        regNums.add("4321");

        System.out.println(parking.addCar(car));
        System.out.println(parking.addCar(car));
        System.out.println(parking.addCar(car2));


    }
}
