package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Tail {
	
    public void drawAt(int left, int bottom, int width, int height) {
    	
        Drawing.getPen().setColor(Color.PINK);
        Drawing.getPen().drawArc(left, bottom, width / 10, height / 10, 0, 270); // curly tail
    }
}