package org.test.drawing.console.utilities;

import org.test.drawing.console.exceptions.InvalidParametersException;
import org.test.drawing.console.model.Canvas;
import org.test.drawing.console.model.Dot;
import org.test.drawing.console.model.Line;
import org.test.drawing.console.enums.CharacterEnum;
import org.test.drawing.console.validators.CanvasValidator;

public class CanvasUtility {

    public static void drawLine(Canvas canvas, Line line){
        CanvasValidator.validateLinePoints(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        for(int i=line.getY1(); i<=line.getY2(); i++) {
            for (int j = line.getX1(); j <= line.getX2(); j++) {
                Dot updatedDot = new Dot(j , i, 'x');
                canvas.getAllDots().put(updatedDot, updatedDot);
            }
        }
    }

    public static void deleteLine(Canvas canvas, Line line){
        CanvasValidator.validateLinePoints(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        for(int i=line.getY1(); i<=line.getY2(); i++) {
            for (int j = line.getX1(); j <= line.getX2(); j++) {
                Dot updatedDot = new Dot(j , i, ' ');
                canvas.getAllDots().put(updatedDot, updatedDot);
            }
        }
    }

     public static void resetCanvasMatrix(Canvas canvas){
        canvas.resetShapes();
    }

    public static void resetCanvasMatrixStruct(Canvas canvas) {
        char[][] canvasMatrix = canvas.getCanvasMatrix();
        for (int i = 1; i < canvas.getHeight() - 1; i++) {
            for (int j = 1; j < canvas.getWidth() - 1; j++) {
                Dot update = new Dot(j, i, CharacterEnum.EMPTY_CHAR.getValue());
                canvas.getAllDots().put(update, update);
            }
        }
    }
    public static void drawDot(Canvas canvas, int x, int y, char c){
        canvas.getCanvasMatrix()[x][y] = c;
    }

    public static void deleteDot(Canvas canvas, int x, int y, char c){
        canvas.getCanvasMatrix()[x][y] = ' ';
    }
    public static void fillColor(Canvas canvas, int x, int y, char c) {
        //avoid filling color on canvas border and beyond canvas border
        try {
            CanvasValidator.validateCoordinatesAgainstCanvas(canvas, x, y);
        } catch (InvalidParametersException ex){
            return;
        }

        Dot update = new Dot(x, y , c);
        Dot existing = canvas.getAllDots().get(update);
        if(existing.getColor() == c || existing.getColor()== CharacterEnum.LINE_CHAR.getValue()){
            return;
        }
        canvas.getAllDots().put(update, update);

        fillColor(canvas, x+1, y, c);
        fillColor(canvas, x-1, y, c);
        fillColor(canvas, x, y+1, c);
        fillColor(canvas, x, y-1, c);
    }

}
