package OOP09_Workshop2.models;

import L10_Workshop_2.exeptions.ArgumentException;
import L10_Workshop_2.helpers.Validator;

public class SailBoat extends Boat {
    public int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if(Validator.validateSailEfficiency(sailEfficiency)){
            this.sailEfficiency = sailEfficiency;
        }else{
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
    }


    @Override
    public double calcSpeed(Race race) {
        return 0;
    }
}
