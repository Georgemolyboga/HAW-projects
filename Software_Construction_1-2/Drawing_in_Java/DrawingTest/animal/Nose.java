package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Nose {
	
    public void drawAt(int left, int bottom, int width, int height) {
        Drawing.getPen().setColor(new Color(255, 100, 150)); // darker pink
        Drawing.getPen().fillOval(left, bottom, width * 2 / 10, height * 10 / 100); // nose base

        Drawing.getPen().setColor(Color.BLACK);
        Drawing.getPen().fillOval(left + width/ 25, bottom + height*3/100, width *3/100, height*3/100); // left nostril
        Drawing.getPen().fillOval(left + width/8, bottom + height*3/100, width *3/100, height*3/100); // right nostril
    }
}