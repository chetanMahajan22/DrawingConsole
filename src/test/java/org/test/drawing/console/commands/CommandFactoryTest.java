package org.test.drawing.console.commands;

import org.test.drawing.console.command.model.Command;
import org.test.drawing.console.constants.MessageConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandFactoryTest {
    private CommandFactory factory = new CommandFactory();
    private String commandStr;
    private Command command;
    String  expectedOutput;

    @Test
    public void testCreateCanvasCommand(){
        commandStr ="c 20 4";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput = "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------";
        Assertions.assertEquals(expectedOutput, command.getCanvas().toString());
    }

    @Test
    public void testLineDrawCommand(){
        createCanvas();
        commandStr="l 1 2 6 2";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput = "----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------";
        command.execute();
        assertEquals(expectedOutput, command.getCanvas().toString());
    }

    @Test
    public void testRectangleDrawCommand(){
        createCanvas();
        commandStr = "r 14 1 18 3";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput =        "----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------";
        command.execute();
        assertEquals(expectedOutput, command.getCanvas().toString());
    }

    @Test
    public void testQuiteCommand(){
        commandStr = "q";
        command = factory.buildCommand(getCommandArr(commandStr));
        Assertions.assertNull(command);
    }

    @Test
    public void testNullCommand(){
        commandStr = null;
        Exception ex = Assertions.assertThrows(Exception.class, () -> command = factory.buildCommand(null));
        Assertions.assertEquals(MessageConstants.EnterValidCommand,ex.getMessage());;
    }


    @Test
    public void testFillColor(){
       createCanvas();
       commandStr = "r 14 1 18 3";
       command = factory.buildCommand(getCommandArr(commandStr));
       command.execute();
        commandStr = "l 1 2 6 2";
        command = factory.buildCommand(getCommandArr(commandStr));
        command.execute();
        commandStr = "l 6 3 6 4";
        command = factory.buildCommand(getCommandArr(commandStr));
        command.execute();
        commandStr = "b 1 1 o";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput = "----------------------\n" +
                "|oooooooooooooxxxxxoo|\n" +
                "|xxxxxxooooooox   xoo|\n" +
                "|     xoooooooxxxxxoo|\n" +
                "|     xoooooooooooooo|\n" +
                "----------------------";
        command.execute();
        assertEquals(expectedOutput, command.getCanvas().toString());

    }

    @Test
    public void testClearCanvasCommand(){
        createCanvas();
        commandStr = "r 14 1 18 3";
        command = factory.buildCommand(getCommandArr(commandStr));
        command.execute();

        commandStr= "clear";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput = "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------";
        assertEquals(expectedOutput, command.getCanvas().toString());
    }


    private String[] getCommandArr(String command){
        return command.split("\\s+");
    }

    private void createCanvas(){
        commandStr ="c 20 4";
        command = factory.buildCommand(getCommandArr(commandStr));

    }

    @Test
    public void testUndoCommand(){
        createCanvas();
        commandStr = "r 14 1 18 3";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput =        "----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------";
        command.execute();
        commandStr= "u";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput ="----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------";
        command.execute();
        assertEquals(expectedOutput, command.getCanvas().toString());

        commandStr = "b 1 1 o";
        command = factory.buildCommand(getCommandArr(commandStr));
        command.execute();

        commandStr= "u";
        command = factory.buildCommand(getCommandArr(commandStr));
        expectedOutput ="----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------";
        command.execute();
        assertEquals(expectedOutput, command.getCanvas().toString());

    }


}
