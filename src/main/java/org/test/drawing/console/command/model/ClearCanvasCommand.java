package org.test.drawing.console.command.model;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.test.drawing.console.model.Canvas;
import org.test.drawing.console.utilities.CanvasUtility;
import org.test.drawing.console.validators.CanvasValidator;

public class ClearCanvasCommand extends Command {

    public ClearCanvasCommand(Canvas canvas, String[] inputArr){
        if(inputArr.length != 1){
            throw new InvalidCommandException(MessageConstants.EnterValidCommand);
        }
        CanvasValidator.validateCanvas(canvas);
        this.canvas = canvas;
        CanvasUtility.resetCanvasMatrix(this.canvas);
    }

}
