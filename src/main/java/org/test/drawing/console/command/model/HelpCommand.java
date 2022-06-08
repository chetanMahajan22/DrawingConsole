package org.test.drawing.console.command.model;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.test.drawing.console.model.Canvas;

public class HelpCommand extends Command{

    public HelpCommand(Canvas canvas, String[] inputArr){
        if(inputArr.length != 1) {
            throw new InvalidCommandException(MessageConstants.EnterValidCommand);
        }
            this.canvas = canvas;
    }

    @Override
    public void execute(){
        printCommandList();
    }

    private void printCommandList() {
        System.out.println("******************* HELP - start ********************");
        System.out.println("Command \t\tDescription");
        System.out.println("C w h \tCreate a new canvas of width w and height h.");
        System.out.println("L x1 y1 x2 y2\tCreate a new line from (x1,y1) to (x2,y2). Line is denoted with character x.");
        System.out.println("R x1 y1 x2 y2 \tCreate a new rectangle, whose upper left corner is (x1,y1) and " +
                "lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.");
        System.out.println("B x y c \tFill the entire area connected to (x,y) with \"colour\" c.");
        System.out.println("Q \tQuit the program.");
        System.out.println("help \tshow valid command list");
        System.out.println("clear \tclear canvas - will clear all drawn objects from canvas");
        System.out.println("******************* HELP - end **********************");
    }
}
