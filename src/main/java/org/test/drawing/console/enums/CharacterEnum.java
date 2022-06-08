package org.test.drawing.console.enums;

public enum CharacterEnum {
    VERTICAL_CHAR('|'),
    HORIZONTAL_CHAR('-'),
    LINE_CHAR('x'),
    EMPTY_CHAR(' ');

    private char c;

    private CharacterEnum(char c){
        this.c = c;
    }

    public char getValue(){
        return c;
    }
}
