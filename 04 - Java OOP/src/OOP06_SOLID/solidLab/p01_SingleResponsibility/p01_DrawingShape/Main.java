package OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape;

import OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {

        DrawingManager drawingManager = new DrawingManagerImpl();

        Shape shape = new Rectangle(1.5, 20);

        drawingManager.draw(shape);
    }
}
