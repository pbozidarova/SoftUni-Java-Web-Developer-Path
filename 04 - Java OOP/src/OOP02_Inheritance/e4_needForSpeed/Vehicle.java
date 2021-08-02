package OOP02_Inheritance.e4_needForSpeed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower){
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = getDefaultFuelConsumption();
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers){
        double fuelCost = this.fuelConsumption * kilometers;
        if(fuelCost <= this.fuel){
            this.fuel -= fuelCost;
        }
    }
}
