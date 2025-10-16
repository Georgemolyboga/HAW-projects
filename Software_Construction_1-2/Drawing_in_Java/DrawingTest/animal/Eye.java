package animal;

import java.awt.Color;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Eye {
	
	private int color1, color2, color3; 
	
    public Eye(int color1, int color2, int color3, boolean randomizeColors) {
    	
    	this.color1 = 0;
    	this.color2 = 0;
    	this.color3 = 0;
    	
    	if (randomizeColors == true) {
    		this.color1  = RandomNumber.between(0, 255);
    		this.color2  = RandomNumber.between(0, 255);
    		this.color3  = RandomNumber.between(0, 255);
    		
//    		color1  = RandomNumber.between(0, 255);
//    		color2  = RandomNumber.between(0, 255);
//    		color3  = RandomNumber.between(0, 255);
    	}
	}

	public void drawAt(int left, int bottom, int width, int height) {
        Drawing.getPen().setColor(Color.WHITE);
        Drawing.getPen().fillOval(left, bottom, width*8/100, height*8/100);
        Drawing.getPen().setColor(new Color(color1, color2, color3));
        Drawing.getPen().fillOval(left + width*2/100, bottom + height*2/100, width*45/1000, height*45/1000); // pupil
    }
}