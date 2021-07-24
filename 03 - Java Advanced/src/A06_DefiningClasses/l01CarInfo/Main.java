package A06_DefiningClasses.l01CarInfo;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.make = "Audi";
        car.model = "A8";

        car.horsePower = -1;

        String toString = String.format("The car is: %s %s - %d HP.",
                car.make,
                car.model,
                car.horsePower);

        System.out.println(toString);

    }
}
