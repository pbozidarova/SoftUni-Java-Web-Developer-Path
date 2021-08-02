//package OOP09_Workshop2.core;
//
//import OOP09_Workshop.core.engine.Engine;
//import OOP09_Workshop2.exeptions.ArgumentException;
//import OOP09_Workshop2.exeptions.DuplicateModelException;
//import OOP09_Workshop2.exeptions.NonExistantModelException;
//import OOP09_Workshop2.models.Boat;
//import OOP09_Workshop2.repositories.Repository;
//import OOP09_Workshop2.repositories.RepositoryImpl;
//
//import java.util.Scanner;
//
//public class MainController {
//    private Scanner scanner;
//    private EngineFactory engineFactory;
//    private BoatFactory boatFactory;
//    private Repository<Engine> engineRepository;
//    private Repository<Boat> boatRepository;
//
//    public MainController(EngineFactory engineFactory, BoatFactory boatFactory){
//        this.scanner = new Scanner(System.in);
//        this.engineRepository = new RepositoryImpl<>();
//        this.boatRepository = new RepositoryImpl<>();
//        this.engineFactory = engineFactory;
//        this.boatRepository = boatFactory;
//        this.boatFactory.setEngineRepository(this.engineRepository);
//    }
//
//    public void run(){
//
//        String line = scanner.nextLine();
//
//        while (!line.equals("End")){
//            String[] args = line.split("\\\\");
//
//            String command = args[0];
//            try {
//
//            switch (command){
//                case "CreateBoatEngine":
//                    engineRepository.add(this.engineFactory.produce(args));
//                    break;
//                case "CreateRowBoat":
//                case "CreatePowerBoat":
//                case "CreateSailBoat":
//                    boatRepository.add(boatFactory.produce(args));
//                    break;
//            }
//            } catch (ArgumentException | DuplicateModelException | NonExistantModelException e) {
//                e.printStackTrace();
//            }
//
//
//            line = scanner.nextLine();
//        }
//    }
//
//}
