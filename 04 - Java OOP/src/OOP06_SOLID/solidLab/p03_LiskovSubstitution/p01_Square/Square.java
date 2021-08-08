package OOP06_SOLID.solidLab.p03_LiskovSubstitution.p01_Square;

public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return 0;
    }


}
