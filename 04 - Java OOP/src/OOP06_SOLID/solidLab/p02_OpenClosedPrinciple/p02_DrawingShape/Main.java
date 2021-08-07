package OOP06_SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import OOP06_SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import OOP06_SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Circle();
        DrawingManager drawingManager = new DrawingManagerImpl();
        drawingManager.draw(shape);
    }
}
