package org.test.drawing.console.command.model;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.test.drawing.console.model.Canvas;

public abstract class Command {
    protected Canvas  canvas;

    public void execute(){
        canvas.printCanvas();
    };

    public Canvas getCanvas(){
        return canvas;
    };
    /**
     * Throws NumberFormat exception  if input string is not number
     * @param input
     * @return Integer value of input string
     */
    protected int getValueAsInt(String input)  {
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException ne ){
            throw new InvalidCommandException(MessageConstants.InvalidCoordinate);
        }
    }
}
