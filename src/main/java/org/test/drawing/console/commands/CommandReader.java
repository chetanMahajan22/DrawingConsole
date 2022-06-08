package org.test.drawing.console.commands;

import org.test.drawing.console.constants.MessageConstants;

import java.util.Scanner;

public class CommandReader {

    private static CommandReader instance;
    private CommandInterpreter cmdInterpreter;
    private Scanner scan ;
    private boolean isAppRun;

    private CommandReader(){
        isAppRun = true;
        scan = new Scanner(System.in);
        cmdInterpreter = new CommandInterpreter();
    }

    public void start(){
        try {
            while (isAppRun) {
                System.out.println(MessageConstants.EnterCommand);
                String command = scan.nextLine();
                try {
                    isAppRun = cmdInterpreter.interpret(command.trim());
                } catch (RuntimeException re) {
                    System.err.println(MessageConstants.ErrorSignal);
                    System.err.println(re.getMessage());
                } catch (Exception e) {
                    System.err.println(MessageConstants.ErrorSignal);
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }finally {
            scan.close();
            System.out.println(MessageConstants.ProgramExitMessage);
        }
    }

    public static CommandReader getInstance(){
        if(instance == null){
            instance =  new CommandReader();
        }
        return instance;
    }
}
