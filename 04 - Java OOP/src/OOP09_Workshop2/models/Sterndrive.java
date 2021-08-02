package OOP09_Workshop2.models;


import OOP09_Workshop2.exeptions.ArgumentException;

public class Sterndrive extends Engine {
    public Sterndrive(String model, int horsepower, int displacement) throws ArgumentException {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return this.getHorsepower() * 7 + this.getDisplacement();
    }

    @Override
    public String getModel() {
        return null;
    }
}
