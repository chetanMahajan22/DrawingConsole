package org.test.drawing.console.commands;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandInterpreterTest {
    private CommandInterpreter interpreter = new CommandInterpreter();
    String command;

    @Test
    public void testInterpreterNullCommand(){
        command = "";
        Exception ex = Assertions.assertThrows(Exception.class, () ->  interpreter.interpret(command));
        Assertions.assertEquals(MessageConstants.EnterValidCommand,ex.getMessage());

    }
    @Test
    public void testInvalidCommand() {
         command ="T 10 7";
        Exception ex = Assertions.assertThrows(Exception.class, () -> interpreter.interpret(command));
        Assertions.assertEquals(MessageConstants.EnterValidCommand,ex.getMessage());
    }

    @Test
    public void testInvalidCreateCanvas() {
        command ="C 10 7 3 3";
        Exception ex = Assertions.assertThrows(Exception.class, () -> interpreter.interpret(command));
        Assertions.assertEquals(MessageConstants.EnterValidCommand,ex.getMessage());
    }


    @Test
    public void testInvalidDrawLine() {

        command ="l 3 2 10 2 3 2";
        Exception ex = Assertions.assertThrows(Exception.class, () -> interpreter.interpret(command));
        Assertions.assertEquals(MessageConstants.EnterValidCommand,ex.getMessage());
    }
    @Test
    public void testInvalidDrawRectangle() {
        command ="r 10 7 3 3 3 2";
        Exception ex = Assertions.assertThrows(Exception.class, () -> interpreter.interpret(command));
        Assertions.assertEquals(MessageConstants.EnterValidCommand,ex.getMessage());
    }

    @Test
    public void testInvalidArguments() {
        command ="c y t";
        InvalidCommandException ex = Assertions.assertThrows(InvalidCommandException.class, () -> interpreter.interpret(command));
        Assertions.assertEquals(MessageConstants.InvalidCoordinate,ex.getMessage());
    }

    @Test
    public void testInvalidArgumentsSpecialChar() {
        command = "C 10 10";
        interpreter.interpret(command);
        command ="r * & 7 3";
        InvalidCommandException ex = Assertions.assertThrows(InvalidCommandException.class, () -> interpreter.interpret(command));
        Assertions.assertEquals(MessageConstants.InvalidCoordinate,ex.getMessage());
    }

    @Test
    public void testCanvasCommandResult() throws Exception {
        command = "C 10 10";
        boolean returnFlag =interpreter.interpret(command);
        Assertions.assertTrue(returnFlag);
    }

    @Test
    public void testRectangleCommandResult(){
        command = "C 10 10";
        interpreter.interpret(command);
        command ="R 1 1 5 5";
        boolean returnFlag =interpreter.interpret(command);
        Assertions.assertTrue(returnFlag);
    }

    @Test
    public void testLineCommandResult(){
        command = "C 10 10";
        interpreter.interpret(command);
        command = "l 7 1 9 1";
        boolean returnFlag =interpreter.interpret(command);
        Assertions.assertTrue(returnFlag);
    }

    @Test
    public void  testClearCommandResult(){
        command = "C 10 10";
        interpreter.interpret(command);
        command = "clear";
        boolean returnFlag =interpreter.interpret(command);
        Assertions.assertTrue(returnFlag);
    }

    @Test
    public void testFillCanvasCommandResult (){
        command = "C 10 10";
        interpreter.interpret(command);
        command = "b 1 1 u";
        boolean returnFlag =interpreter.interpret(command);
        Assertions.assertTrue(returnFlag);
    }

    @Test
    public void testQuiteCommandResult (){
        command ="q";
        boolean returnFlag =interpreter.interpret(command);
        Assertions.assertFalse(returnFlag);
    }

    @Test
    public void testHelpCommandResult(){
        command ="help";
        boolean returnFlag =interpreter.interpret(command);
        Assertions.assertTrue(returnFlag);
    }

}
