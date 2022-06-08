package org.test.drawing.console.validators;

import org.test.drawing.console.model.Canvas;
import org.test.drawing.console.constants.CanvasConstants;
import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCanvasException;
import org.test.drawing.console.exceptions.InvalidParametersException;

public class CanvasValidator {

    public static void validateCanvasSize(int width, int height){
        if(width < 1 || height < 1 || width >  CanvasConstants.MAX_WIDTH  || height > CanvasConstants.MAX_HEIGHT){
            throw new InvalidParametersException(MessageConstants.InvalidDimensions);
        }
    }

    public static void validateLinePoints(int x1, int y1, int x2, int y2) {
        if(x1 > x2 || y1 > y2){
            throw new InvalidParametersException("Line points are invalid, (x1,y1):("+x1+", "+y1+")"+" (x2,y2):("+x2+", "+y2+")");
        }
        if(x1==x2 && y1==y2){ // Single point line is allowed
            return;
        }
        //Validate if not horizontal or vertical line
        if( !((x1==x2 && y1!=y2) || (x1!=x2 && y1==y2) ) ){
            throw new InvalidParametersException(MessageConstants.InvalidLineFormat);
        }
    }

    public static void validateCoordinatesAgainstCanvas(Canvas canvas, int x, int y) {
        if(x < 1 ||  x > canvas.getWidth()-2){
            throw new InvalidParametersException(MessageConstants.InvalidWidth);
        }
        if(y < 1 || y > canvas.getHeight()-2){
            throw new InvalidParametersException(MessageConstants.InvalidHeight);
        }
    }

    public static void validateCanvas(Canvas canvas){
        if(canvas == null) {
            throw new InvalidCanvasException(MessageConstants.InvalidCanvas);
        }
    }

}
