package animal;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Mole {
	
    private int size;
    
    public void drawAt(int left, int bottom, int width, int height) {

        size = RandomNumber.between(width / 20, width / 50);

        Drawing.getPen().setColor(new Color(255, 100, 150)); // darker pink
        Drawing.getPen().fillOval(left, bottom, size, size);
    }
}