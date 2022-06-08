package org.test.drawing.console.model;

import org.test.drawing.console.interfaces.Shape;
import org.test.drawing.console.utilities.CanvasUtility;

public class Rectangle implements Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Canvas canvas) {
        CanvasUtility.drawLine(canvas, new Line( x1, y1, x1, y2));
        CanvasUtility.drawLine(canvas, new Line( x1, y1, x2, y1));
        CanvasUtility.drawLine(canvas, new Line( x2, y1, x2, y2));
        CanvasUtility.drawLine(canvas, new Line( x1, y2, x2, y2));
    }

    @Override
    public void delete(Canvas canvas) {
        CanvasUtility.deleteLine(canvas, new Line( x1, y1, x1, y2));
        CanvasUtility.deleteLine(canvas, new Line( x1, y1, x2, y1));
        CanvasUtility.deleteLine(canvas, new Line( x2, y1, x2, y2));
        CanvasUtility.deleteLine(canvas, new Line( x1, y2, x2, y2));
    }
}
