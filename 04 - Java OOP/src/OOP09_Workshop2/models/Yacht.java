package OOP09_Workshop2.models;


import OOP09_Workshop2.exeptions.ArgumentException;
import OOP09_Workshop2.helpers.Validator;

import static OOP09_Workshop2.helpers.Validator.generateErrorMessage;

public class Yacht extends Boat {
    private Engine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, Engine engine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    public void setCargoWeight(int cargoWeight) throws ArgumentException {
        if (Validator.validateParam(cargoWeight)) {
            this.cargoWeight = cargoWeight;
        }else {
            throw new ArgumentException(generateErrorMessage("Cargo Weight"));
        }
    }

    @Override
    public double calcSpeed(Race race) {
        return 0;
    }
}
