package org.test.drawing.console;

import org.test.drawing.console.commands.CommandReader;

public class DrawingConsoleApplication {
    public static void main(String[] args) {
        CommandReader.getInstance().start();
    }
}
