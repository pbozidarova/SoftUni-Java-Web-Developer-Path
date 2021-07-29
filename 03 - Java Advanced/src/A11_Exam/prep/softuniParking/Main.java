package A11_Exam.prep.softuniParking;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Parking parking = new Parking(5);

        Car car = new Car("Skoda", "Fabia",65, "CC1856AA");
        Car car2 = new Car("Audi", "A3",110, "EB8877MN");

        System.out.println(car.toString());

        List<String> regNums = new ArrayList<>();
        regNums.add("CC1856AA");
        regNums.add("EB8877MN");
        regNums.add("invalid");

        System.out.println(parking.addCar(car));
        System.out.println(parking.addCar(car));
        System.out.println(parking.addCar(car2));

        System.out.println(parking.getCar("EB8877MN"));

        System.out.println(parking.removeCar("EB8877MNs"));

        System.out.println(parking.getCount());

        parking.removeSetOfRegistrationNumber(regNums);

    }
}
