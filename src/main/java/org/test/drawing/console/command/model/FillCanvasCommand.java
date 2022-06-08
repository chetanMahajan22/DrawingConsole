package org.test.drawing.console.command.model;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.test.drawing.console.model.Canvas;
import org.test.drawing.console.model.Dot;
import org.test.drawing.console.utilities.CanvasUtility;
import org.test.drawing.console.validators.CanvasValidator;


public class FillCanvasCommand extends Command {

    public FillCanvasCommand(Canvas canvas, String[] inputArr){
        if(inputArr.length != 4)
            throw new InvalidCommandException(MessageConstants.EnterValidCommand);
        CanvasValidator.validateCanvas(canvas);
        CanvasValidator.validateCoordinatesAgainstCanvas(canvas, getValueAsInt(inputArr[1]), getValueAsInt(inputArr[2]));
        this.canvas = canvas;
        Dot dot= new Dot(getValueAsInt(inputArr[1]), getValueAsInt(inputArr[2]), inputArr[3].charAt(0));
        this.canvas.addShape(dot);
        CanvasUtility.fillColor(canvas, getValueAsInt(inputArr[1]), getValueAsInt(inputArr[2]), inputArr[3].charAt(0));
    }


}
