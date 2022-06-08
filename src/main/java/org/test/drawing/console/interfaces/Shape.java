package org.test.drawing.console.interfaces;

import org.test.drawing.console.model.Canvas;

public interface Shape extends  Deletable{
    void draw(Canvas canvas);
}
