package org.test.drawing.console.commands;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.model.Canvas;
import org.test.drawing.console.validators.CommandValidator;
import org.test.drawing.console.command.model.*;

public class CommandFactory {
    private CommandValidator validator;
    private Command command;
    private Canvas canvas = null;

    public CommandFactory(){
        validator = new CommandValidator();
    }

    public Command buildCommand(String[] inputArr){
        command= null;
        validator.validateCommand(inputArr);
        switch(inputArr[0].toUpperCase()) {
            case "C" :
                    command = new CanvasCommand(inputArr);
                    canvas = command.getCanvas();
                    break;
            case "L":
                    command = new LineCommand(canvas, inputArr);
                    canvas = command.getCanvas();
                    break;
            case "R" :
                    command = new RectangleCommand(canvas, inputArr);
                    canvas = command.getCanvas();
                    break;
            case "B" :
                    command = new FillCanvasCommand(canvas, inputArr);
                    canvas = command.getCanvas();
                    break;
            case "Q" :
                    System.out.println(MessageConstants.ExitMessage);
                    command = null;
                    break;
            case "HELP" :
                    command = new HelpCommand(canvas, inputArr);
                    break;
            case "CLEAR" :
                    command = new ClearCanvasCommand(canvas, inputArr);
                    canvas = command.getCanvas();
                    break;
            case "U" :
                command = new UndoCommand(canvas, inputArr);
                canvas = command.getCanvas();
                break;
        }
        return command;
    }


}
