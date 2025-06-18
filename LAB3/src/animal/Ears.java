package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Ears {
    public void drawAt(int left, int bottom, int width, int height) {
        Drawing.getPen().setColor(Color.PINK);
        int[] xPoints = {left, left + width*7/100, left + width*14/100};
        int[] yPoints = {bottom, bottom - height/7, bottom};
        Drawing.getPen().fillPolygon(xPoints, yPoints, 3); // triangle ear
    }
}