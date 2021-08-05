package OOP05_Polymorphism.l02shapes;

public class Rectangle extends Shape{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 * (this.height + this.width);
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = this.height * this.width;
        super.setArea(result);
    }
}
