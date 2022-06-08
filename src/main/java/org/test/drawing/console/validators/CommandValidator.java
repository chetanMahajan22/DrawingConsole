package org.test.drawing.console.validators;

import org.test.drawing.console.enums.CommandEnum;
import org.test.drawing.console.constants.MessageConstants;
import org.test.drawing.console.exceptions.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandValidator {

    public void validateCommand(String[] actionArr) {
        if(actionArr == null || actionArr.length == 0){
            throw new InvalidCommandException(MessageConstants.EnterValidCommand);
        }
        String action = actionArr[0];
        if(! getValidCommandList().contains(action.toUpperCase())){
            throw new InvalidCommandException(MessageConstants.EnterValidCommand);
        }
    }

    private List<String> getValidCommandList(){
        return Arrays.stream(CommandEnum.values()).map(command -> command.getValue()).collect(Collectors.toList());
    }

}
