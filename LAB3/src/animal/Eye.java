package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Eye {
    public void drawAt(int left, int bottom, int width, int height) {
        Drawing.getPen().setColor(Color.WHITE);
        Drawing.getPen().fillOval(left, bottom, width*8/100, height*8/100);
        Drawing.getPen().setColor(Color.BLACK);
        Drawing.getPen().fillOval(left + width*2/100, bottom + height*2/100, width*45/1000, height*45/1000); // pupil
    }
}