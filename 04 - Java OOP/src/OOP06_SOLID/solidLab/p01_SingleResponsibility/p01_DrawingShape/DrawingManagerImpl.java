package OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape;

import OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import OOP06_SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {

    public DrawingManagerImpl(){
    }


    @Override
    public void draw(Shape shape) {
        shape.draw();
    }
}
