package org.test.drawing.console.model;

import org.test.drawing.console.interfaces.Shape;
import org.test.drawing.console.utilities.CanvasUtility;

public class Dot implements Shape {

    private int x;
    private int y;
    private char color;

    public Dot(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {
        CanvasUtility.drawDot(canvas, x, y , color);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || ! (obj instanceof Dot)){
            return false;
        }
        Dot nDot = (Dot) obj;
        return this.x == nDot.x && this.y == nDot.y;
    }

    @Override
    public int hashCode(){
        return (x * y) + 7;
    }

    @Override
    public void delete(Canvas canvas) {
        CanvasUtility.fillColor(canvas, getX(), getY(),  ' ');
    }
}

