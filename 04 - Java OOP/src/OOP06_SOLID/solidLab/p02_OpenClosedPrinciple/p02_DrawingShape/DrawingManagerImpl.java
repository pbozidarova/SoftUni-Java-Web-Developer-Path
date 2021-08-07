package OOP06_SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import OOP06_SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import OOP06_SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {

    @Override
    public void draw(Shape shape) {
        if (shape instanceof Circle)
        {
            this.drawCircle((Circle)shape);
        }
            else if (shape instanceof Rectangle)
        {
            this.drawRectangle(((Rectangle)shape));
        }
    }
    public void drawCircle(Circle circle)
    {
        // Draw Circle
    }

    public void drawRectangle(Rectangle rectangle)
    {
        // Draw Rectangle
    }

}
