package OOP06_SOLID.solidLab.p03_LiskovSubstitution.p01_Square;

public class Rectangle extends Shape {
   private double width;

   private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
       return this.width*this.height;
    }
}
