package org.test.drawing.console.model;

import org.test.drawing.console.interfaces.Shape;
import org.test.drawing.console.utilities.CanvasUtility;


public class Line implements Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public void draw(Canvas canvas) {
        CanvasUtility.drawLine(canvas, this);
    }

    @Override
    public void delete(Canvas canvas) {
        CanvasUtility.deleteLine(canvas, this);
    }
}
