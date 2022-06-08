package org.test.drawing.console.commands;

import org.test.drawing.console.command.model.Command;

public class CommandInterpreter {
    CommandFactory factory;

    public CommandInterpreter(){
        factory = new CommandFactory();
    }

    public boolean interpret(String line) {
        String[] inputArr = line.split("\\s+");
        Command command = factory.buildCommand(inputArr);
       if(command != null) {
           command.execute();
           return true;
       }
       return false;
    }

}
