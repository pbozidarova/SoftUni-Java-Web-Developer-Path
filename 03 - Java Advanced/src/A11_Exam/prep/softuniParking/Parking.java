package A11_Exam.prep.softuniParking;

import java.util.HashMap;
import java.util.List;
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


    public Car getCar(String registrationNumber){
        return this.cars.get(registrationNumber);
    }

    public String removeCar(String registrationNumber){
        String message;
        if(!this.cars.containsKey(registrationNumber)){
            message = "Car with that registration number does not exist!";
        }else {
            this.cars.remove(registrationNumber);
            message = "Successfully removed " + registrationNumber;
        }

        return message;
    }

    public int getCount(){
        return this.cars.size();
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers){
        for (String registrationNumber : registrationNumbers) {
            this.removeCar(registrationNumber);
        }

//        StringBuilder sb = new StringBuilder();
//
//        for (String registrationNumber : registrationNumbers) {
//            sb.append(this.removeCar(registrationNumber))
//               .append(System.lineSeparator());
//        }
//
//        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "";
    }
}
