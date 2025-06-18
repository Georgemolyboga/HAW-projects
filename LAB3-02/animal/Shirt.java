package animal;

import java.awt.Color;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Shirt {
	
	private int color1, color2, color3;
	
    public void drawAt(int left, int bottom, int width, int height) {
    	
    	color1  = RandomNumber.between(0, 255);
    	color2  = RandomNumber.between(0, 255);
    	color3  = RandomNumber.between(0, 255);

        Drawing.getPen().setColor(new Color(color1, color2, color3));
        Drawing.getPen().fillArc(left, bottom, width, height/2, 270, 180);

        Drawing.getPen().setColor(Color.WHITE);
        Drawing.getPen().drawString("Oink!", left + width*6/10, bottom + height/3);
    }
}