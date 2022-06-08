package org.test.drawing.console.constants;

public class MessageConstants {
    public static final String EnterCommand = "enter command : ";
    public static final String ErrorSignal = "***********************";
    public static final String EnterValidCommand = "Enter valid command. Check valid command list with 'help' command.";
    public static final String InvalidCanvas = "Create canvas first to draw any object.";
    public static final String InvalidLineFormat = "Allowed only vertical or horizontal line. (Combination vertical line(x1 == x2), horizontal line(y1 == y2)).";
    public static final String InvalidWidth = "Width coordinate should be within canvas. Please try again.";
    public static final String InvalidHeight = "Height coordinate should be within canvas. Please try again.";
    public static final String InvalidCoordinate = "Coordinate value should only be number. Please enter valid coordinates.";
    public static final String InvalidDimensions = new StringBuilder("Canvas can't be created with given dimensions. ").
            append("( 0<x<=").append(CanvasConstants.MAX_WIDTH).append(", 0<y<=").append(CanvasConstants.MAX_HEIGHT).append(" )").toString();
    public static final String ExitMessage = "Exit command received !";
    public static final String ProgramExitMessage = "Program is shutting down.";
    public static final String ClearCanvasMessage = "Clearing canvas!- Deleting all drawn objects from Canvas.";

}
