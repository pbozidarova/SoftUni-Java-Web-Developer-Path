package OOP01_WorkingWithAbstraction.l02pointinrectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.bottomLeft = topLeft;
        this.topRight = bottomRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Point point){
        boolean containsOnX = point.getX() >= bottomLeft.getX()
                && point.getX() <= topRight.getX();

        boolean containsOnY = point.getY() >= bottomLeft.getY()
                && point.getY() <= topRight.getY();

        return  containsOnX && containsOnY;
    }
}
