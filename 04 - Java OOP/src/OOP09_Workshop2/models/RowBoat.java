package OOP09_Workshop2.models;

import L10_Workshop_2.exeptions.ArgumentException;
import L10_Workshop_2.helpers.Validator;

import static L10_Workshop_2.helpers.Validator.generateErrorMessage;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) throws ArgumentException {
        if(Validator.validateParam(oars)){
            this.oars = oars;
        }else {
            throw new ArgumentException(generateErrorMessage("Oars"));
        }
    }


    @Override
    public double calcSpeed(Race race) {
        //(Oars * 100) - Boat Weight + Race Ocean Current Speed

        return 0;
    }
}
