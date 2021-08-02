package OOP09_Workshop2.models;


import OOP09_Workshop2.exeptions.ArgumentException;
import OOP09_Workshop2.helpers.Validator;
import OOP09_Workshop2.models.interfaces.Model;
import OOP09_Workshop2.models.interfaces.Speed;

import static OOP09_Workshop2.helpers.Validator.generateErrorMessage;

public abstract class Boat implements Comparable<Boat>, Speed, Model {
    private static final int MIN_MODEL_LENGTH = 5;
    private String model;
    private int weight;

    protected Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setWeight(int weight) throws ArgumentException {
        if(Validator.validateParam(weight)){
            this.weight = weight;
        }else{
            throw new ArgumentException(generateErrorMessage("Weight"));
        }
    }


    private void setModel(String model) throws ArgumentException {
        if(Validator.validateBoatModel(model)){
            this.model = model;
        } else{
            throw new ArgumentException("Model's name must be at least " + MIN_MODEL_LENGTH + " symbols long.");
        }
    }

    protected int getWeight(){
        return this.weight;
    }

    @Override
    public String getModel(){
        return this.model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass() ) return false;

        Boat boat = (Boat) o;

        return model.equals(boat.model);
    }

    @Override
    public int hashCode() {
        return model.hashCode();
    }

    @Override
    public int compareTo(Boat o) {
        return this.model.compareTo(o.model);
    }
}
