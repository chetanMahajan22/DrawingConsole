package org.test.drawing.console.validators;

import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandValidatorTest {
    private CommandValidator validator = new CommandValidator();

    @Test
    public void testValidateNullCommand(){
        InvalidCommandException ex = Assertions.assertThrows(InvalidCommandException.class,
                () ->validator.validateCommand(null));
        Assertions.assertEquals(MessageConstants.EnterValidCommand, ex.getMessage());

        ex = Assertions.assertThrows(InvalidCommandException.class,
                () ->validator.validateCommand("T".split(" ")));
        Assertions.assertEquals(MessageConstants.EnterValidCommand, ex.getMessage());

        Assertions.assertDoesNotThrow( () -> validator.validateCommand("c".split(" ")));

    }

}
