package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Tail {
	
	private int color1, color2, color3;
	
    public Tail(int color1, int color2, int color3) {

    	this.color1 = color1;
    	this.color2 = color2;
    	this.color3 = color3;
	}

	public void drawAt(int left, int bottom, int width, int height) {
    	
        Drawing.getPen().setColor(new Color(color1, color2, color3));
        Drawing.getPen().drawArc(left, bottom, width / 10, height / 10, 0, 270); // curly tail
    }
}