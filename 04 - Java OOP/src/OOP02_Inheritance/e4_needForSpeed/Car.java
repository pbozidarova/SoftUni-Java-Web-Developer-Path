package OOP02_Inheritance.e4_needForSpeed;

public class Car extends Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);

    }
}
