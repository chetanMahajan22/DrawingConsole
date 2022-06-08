package org.test.drawing.console.command.model;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.test.drawing.console.model.Canvas;
import org.test.drawing.console.model.Rectangle;
import org.test.drawing.console.validators.CanvasValidator;

public class RectangleCommand extends Command {

    public RectangleCommand(Canvas canvas, String[] inputArr){
        if (inputArr.length != 5)
            throw new InvalidCommandException(MessageConstants.EnterValidCommand);
        CanvasValidator.validateCanvas(canvas);
        CanvasValidator.validateCoordinatesAgainstCanvas(canvas, getValueAsInt(inputArr[1]), getValueAsInt(inputArr[2]));
        CanvasValidator.validateCoordinatesAgainstCanvas(canvas, getValueAsInt(inputArr[3]), getValueAsInt(inputArr[4]));
        Rectangle rectangle = new Rectangle( getValueAsInt(inputArr[1]), getValueAsInt(inputArr[2]),
                getValueAsInt(inputArr[3]), getValueAsInt(inputArr[4]));
        this.canvas = canvas;
        this.canvas.addShape(rectangle);
    }

}
