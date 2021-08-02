package OOP09_Workshop2.models;

import OOP09_Workshop2.exeptions.ArgumentException;

public class PowerBoat extends Boat {
    private Engine primaryEngine;
    private Engine secondaryEngine;

    public PowerBoat(String model, int weight, Engine primaryEngine, Engine secondaryEngine) throws ArgumentException {
        super(model, weight);
        this.primaryEngine = primaryEngine;
        this.secondaryEngine = secondaryEngine;
    }

    @Override
    public double calcSpeed(Race race) {
        //(Engine 1 Output + Engine 2 Output) - Boat’s Weight + (Race Ocean Current Speed / 5);

        return (this.primaryEngine.getOutput() + this.secondaryEngine.getOutput()) -
                        - this.getWeight() +
                        + (race.getCurrentSpeed() / 5.0) ;
    }
}
