package OOP05_Polymorphism.e2;

import L5_Polymorphism.e2.vehicle.Bus;
import L5_Polymorphism.e2.vehicle.Car;
import L5_Polymorphism.e2.vehicle.Truck;
import L5_Polymorphism.e2.vehicle.Vehicle;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = produceVehicle(scanner.nextLine().split("\\s+"));
        Vehicle truck = produceVehicle(scanner.nextLine().split("\\s+"));
        Vehicle bus = produceVehicle(scanner.nextLine().split("\\s+"));

        LinkedHashMap<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);


        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String output = null;

            if (tokens[0].contains("Drive")) {
                if(tokens[0].contains("Empty")) vehicles.get(tokens[1]).setAirConditioningIsOn();
                output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            } else {
                vehicles.get(tokens[1]).reFuel(Double.parseDouble(tokens[2]));
            }

            if(output != null){
                System.out.println(output);
            }
        }

        vehicles.forEach((key, value) -> System.out.println(value));

    }

    public static Vehicle produceVehicle(String[] data) {
        Vehicle vehicle = null;

        if (data[0].equals("Car")) {
            vehicle = new Car(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        } else if (data[0].equals("Truck")) {
            vehicle = new Truck(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        } else if (data[0].equals("Bus")) {
            vehicle = new Bus(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]));
        }
        return vehicle;
    }
}

