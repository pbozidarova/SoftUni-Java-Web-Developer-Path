package OOP09_Workshop2;


import L10_Workshop_2.core.*;

public class Main {
    public static void main(String[] args) {

        EngineFactory engineFactory = new EngineProducer();
        BoatFactory boatFactory = new BoatWorkshop();
        MainController controller = new MainController(engineFactory, boatFactory);
        controller.run();
    }

}
