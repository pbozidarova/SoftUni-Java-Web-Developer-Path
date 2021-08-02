package OOP05_Polymorphism.e2.vehicle;
import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private boolean airConditioningIsOn;
    private double additionalConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double additionalConsumption, double tankCapacity){
        this.fuelQuantity = fuelQuantity;
        this.setAirConditioningIsOn();
        this.additionalConsumption = additionalConsumption;
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity, fuelQuantity);

    }

    protected void setTankCapacity(double tankCapacity, double fuelQuantity){
        if(tankCapacity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if( fuelQuantity > tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        } else{
            this.tankCapacity = tankCapacity;
        }
    }

    protected void setFuelConsumption(double fuelConsumption){
        if(airConditioningIsOn) {
            this.fuelConsumption = fuelConsumption + additionalConsumption;
        }else{
            this.fuelConsumption = fuelConsumption;
        }
    }

    public void setAirConditioningIsOn(){
        this.airConditioningIsOn = true;
    }

    public String drive(double distance){
        String output = null;
        double fuelNeeded = distance*this.fuelConsumption;
        if(fuelNeeded <= this.fuelQuantity){
            this.fuelQuantity -= fuelNeeded;

            DecimalFormat format = new DecimalFormat("#.##");

            output = this.getClass().getSimpleName() + " travelled " + format.format(distance )+ " km";

        }else {
            output = this.getClass().getSimpleName() + " needs refueling";
        }

        return output;
    }

    public void reFuel(double fuel){

        if(fuel <= 0){
            System.out.println("Fuel must be a positive number");
        }else if(this.tankCapacity < (this.fuelQuantity + fuel)){
            System.out.println("Cannot fit fuel in tank");
        } else{
            this.fuelQuantity += fuel;
        }
    }



    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
