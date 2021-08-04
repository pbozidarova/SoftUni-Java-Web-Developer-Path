package OOP04_InterfacesAndAbstraction.l02extend;

public class Seat extends CarImpl implements Sellable{

    private Double price;

    public Seat(String model, String color, int horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice(){
        return this.price;
    }

    public String toString() {
        String format = "%s sells for %f";
        return super.toString()
                + System.lineSeparator()
                + String.format(format, this.getModel(), this.getPrice());
    }
}
