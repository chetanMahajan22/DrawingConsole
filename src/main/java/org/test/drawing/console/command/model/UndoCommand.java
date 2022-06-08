package org.test.drawing.console.command.model;

import org.test.drawing.console.model.Canvas;

public class UndoCommand extends Command{

    public UndoCommand(Canvas canvas, String[] inputArr){
        this.canvas= canvas;
        unodOperation();
    }


    private void unodOperation(){
        this.canvas=  getCanvas().removeLastShape();

    }
}
