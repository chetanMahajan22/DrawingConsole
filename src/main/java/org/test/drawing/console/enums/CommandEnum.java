package org.test.drawing.console.enums;

public enum CommandEnum {

    DrawCanvas("C"),
    DrawLine("L"),
    DrawRectangle("R"),
    FillCanvas("B"),
    HELP("HELP"),
    ClearCanvas("CLEAR"),
    Quite("Q"),
    Undo("U");

    private String command;
    private CommandEnum(String command){
        this.command = command;
    }

    public String getValue(){
        return command;
    }

}
