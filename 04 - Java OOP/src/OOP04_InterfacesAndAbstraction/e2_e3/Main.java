package OOP04_InterfacesAndAbstraction.e2_e3;

import L4_Interfaces_And_Abstractions.e2_e3.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String subject = input.split("\\s+")[0];


            switch (subject){
                case "Citizen":
            //      Citizen citizen = new Citizen(
            //              input.split("\\s+")[1],
            //              Integer.parseInt(input.split("\\s+")[2]),
            //              input.split("\\s+")[3],
            //              input.split("\\s+")[4]
            //      );
            //      citizens.add(citizen);
            //      break;
                case "L4_Interfaces_And_Abstractions.e2_e3.Pet":
                    Pet pet = new Pet(
                            input.split("\\s+")[0],
                            input.split("\\s+")[0]
                    );
                    pets.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String compairDate = scanner.nextLine();
    //    for (Citizen citizen : citizens) {
    //        String birthYear = citizen.getBirthDate().substring(citizen.getBirthDate().lastIndexOf("/")+1);
    //        if(compairDate.equals(birthYear)){
    //            System.out.println(citizen.getBirthDate());
    //        }
    //    }
        for (Pet pet : pets) {
            String birthYear = pet.getBirthDate().substring(pet.getBirthDate().lastIndexOf("/") + 1);
            if(compairDate.equals(birthYear)){
                System.out.println(pet.getBirthDate());
            }

        }

    }
}
