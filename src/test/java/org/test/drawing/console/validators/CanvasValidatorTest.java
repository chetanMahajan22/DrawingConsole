package org.test.drawing.console.validators;

import org.test.drawing.console.constants.CanvasConstants;
import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCanvasException;
import org.test.drawing.console.exceptions.InvalidParametersException;
import org.test.drawing.console.model.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanvasValidatorTest {

    @Test
    public void testValidateCanvasSize(){
        InvalidParametersException ex = Assertions.assertThrows(InvalidParametersException.class, () ->CanvasValidator.validateCanvasSize(0, 15));
        Assertions.assertEquals(MessageConstants.InvalidDimensions, ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () ->CanvasValidator.validateCanvasSize(15, 0));
        Assertions.assertEquals(MessageConstants.InvalidDimensions, ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () ->CanvasValidator.validateCanvasSize(CanvasConstants.MAX_WIDTH, CanvasConstants.MAX_HEIGHT+1));
        Assertions.assertEquals(MessageConstants.InvalidDimensions, ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () ->CanvasValidator.validateCanvasSize(CanvasConstants.MAX_WIDTH+1, CanvasConstants.MAX_HEIGHT+1));
        Assertions.assertEquals(MessageConstants.InvalidDimensions, ex.getMessage());
    }

    @Test
    public void testValidateLinePoint(){
        InvalidParametersException ex = Assertions.assertThrows(InvalidParametersException.class, () -> CanvasValidator.validateLinePoints(4, 6,1 , 4));
        Assertions.assertEquals("Line points are invalid, (x1,y1):(4, 6) (x2,y2):(1, 4)", ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () -> CanvasValidator.validateLinePoints(2, 2, 4, 4));
        Assertions.assertEquals(MessageConstants.InvalidLineFormat, ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () -> CanvasValidator.validateLinePoints(2, 2, 4, 4));
        Assertions.assertEquals(MessageConstants.InvalidLineFormat, ex.getMessage());

        Assertions.assertDoesNotThrow( () -> CanvasValidator.validateLinePoints(2, 4, 2, 4));

    }

    @Test
    public void testValidateCoordinatesAgainstCanvas(){
        Canvas canvas = new Canvas(20 , 5);
        InvalidParametersException ex = Assertions.assertThrows(InvalidParametersException.class, () -> CanvasValidator.validateCoordinatesAgainstCanvas(canvas, 0, 6));
        Assertions.assertEquals(MessageConstants.InvalidWidth, ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () -> CanvasValidator.validateCoordinatesAgainstCanvas(canvas, 7, 0));
        Assertions.assertEquals(MessageConstants.InvalidHeight, ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () -> CanvasValidator.validateCoordinatesAgainstCanvas(canvas, 7, 6));
        Assertions.assertEquals(MessageConstants.InvalidHeight, ex.getMessage());

        ex = Assertions.assertThrows(InvalidParametersException.class, () -> CanvasValidator.validateCoordinatesAgainstCanvas(canvas, 21, 4));
        Assertions.assertEquals(MessageConstants.InvalidWidth, ex.getMessage());
    }

    @Test
    public void testValidateCanvas(){
        InvalidCanvasException ex = Assertions.assertThrows(InvalidCanvasException.class, ()-> CanvasValidator.validateCanvas(null));
        Assertions.assertEquals(MessageConstants.InvalidCanvas, ex.getMessage());
    }
}
