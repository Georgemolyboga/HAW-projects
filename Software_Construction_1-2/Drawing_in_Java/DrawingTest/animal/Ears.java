package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Ears {
	
	private int color1, color2, color3;
	
    public Ears(int color1, int color2, int color3) {
    	
    	this.color1 = color1;
    	this.color2 = color2;
    	this.color3 = color3;
	}

	public void drawAt(int left, int bottom, int width, int height) {
		
        Drawing.getPen().setColor(new Color(color1, color2, color3));
        int[] xPoints = {left, left + width*7/100, left + width*14/100};
        int[] yPoints = {bottom, bottom - height/7, bottom};
        Drawing.getPen().fillPolygon(xPoints, yPoints, 3); // triangle ear
    }
}