package org.test.drawing.console.model;

import org.test.drawing.console.enums.CharacterEnum;
import org.test.drawing.console.interfaces.Shape;
import org.test.drawing.console.utilities.CanvasUtility;

import java.util.*;


public class Canvas {
    private int height;
    private int width;
    private char[][]  canvasMatrix;
    private List<Shape> shapes;
    private Map<Dot, Dot> allDots;

    public Canvas(int width, int height){
        this.width = width+2;
        this.height = height+2;
        shapes = new ArrayList<>();
        allDots = new HashMap<>();
        createMatrix(this.width, this.height);
    }

    public char[][] getCanvasMatrix(){
        return canvasMatrix;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void printCanvas(){
        System.out.println(this);
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void resetShapes(){
        shapes = new ArrayList<>();
    }

    private void createMatrix(int width, int height) {
        canvasMatrix = new char[width][height];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                Dot dot;
                if (i == 0 || i == height - 1) {
                    dot = new Dot(j , i, CharacterEnum.HORIZONTAL_CHAR.getValue());
                    //canvasMatrix[j][i] = CharacterEnum.HORIZONTAL_CHAR.getValue();
                }else if (j == 0 || j == width - 1) {
                    dot = new Dot(j , i, CharacterEnum.VERTICAL_CHAR.getValue());
                    //canvasMatrix[j][i] = CharacterEnum.VERTICAL_CHAR.getValue();
                } else {
                    dot = new Dot(j , i, CharacterEnum.EMPTY_CHAR.getValue());
                    //canvasMatrix[j][i] = CharacterEnum.EMPTY_CHAR.getValue();
                }
                allDots.put(dot, dot);
            }
        }
    }

    @Override
    public String toString(){
        CanvasUtility.resetCanvasMatrixStruct(this);
       for(int i = 0 ; i < shapes.size(); i++){
           if (shapes.get(i) instanceof  Dot){
               Dot dot = (Dot)shapes.get(i);
               CanvasUtility.fillColor(this, dot.getX(), dot.getY(),  dot.getColor());
           }
           shapes.get(i).draw(this);
       }
        allDots.values().forEach(dot -> dot.draw(this));
        //allDots.stream().forEach(dot -> dot.draw(this));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(canvasMatrix[j][i]);
            }
            if (i != height - 1)
                sb.append("\n");
            }
        return sb.toString();
    }

    public Map<Dot, Dot> getAllDots(){
        return this.allDots;
    }

    public void resetAllDots(){
        allDots = new HashMap<>();
    }

    public Canvas removeLastShape(){
        int lastIndex = shapes.size()-1;
        if(lastIndex >= 0) {
            Shape s = shapes.get(lastIndex);
            s.delete(this);
            shapes.remove(lastIndex);
        }
        return this;
    }

}
