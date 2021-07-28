package A11_Exam.prep.softuniParking;

import java.util.HashMap;
import java.util.Map;

public class Parking {

    Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<>();
    }

    public String addCar(Car car){
        String message;
        if(this.cars.containsKey(car.getRegistrationNumber())){
            message = "Car with that registration number already exists!";
        }else if(this.cars.size() >= this.capacity){
            message = "Parking is full!";
        }else {
            this.cars.put(car.getRegistrationNumber(), car);
            message = String.format("Successfully added new car %s %s",
                    car.getMake(),
                    car.getRegistrationNumber());
        }

        return message;
    }

    public Car removeCar(String registrationNumber){
        return this.cars.remove(registrationNumber);
    }

    public Car getCar(String registrationNumber){
        return this.cars.get(registrationNumber);
    }

    public int getCount(){
        return this.cars.size();
    }

    @Override
    public String toString() {
        return "";
    }
}
