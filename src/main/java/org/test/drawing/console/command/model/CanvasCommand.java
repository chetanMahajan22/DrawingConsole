package org.test.drawing.console.command.model;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.test.drawing.console.model.Canvas;
import org.test.drawing.console.validators.CanvasValidator;

public class CanvasCommand extends Command {

    public CanvasCommand(String[] inputArr){
        if(inputArr.length != 3){
            throw new InvalidCommandException(MessageConstants.EnterValidCommand);
        }
        CanvasValidator.validateCanvasSize(getValueAsInt(inputArr[1]), getValueAsInt(inputArr[2]));
        this.canvas =  new Canvas(getValueAsInt(inputArr[1]), getValueAsInt(inputArr[2]));
    }


}
