package animal;

import java.awt.Color;

import drawingTool.Drawing;

public class Hoof {
    public void drawAt(int left, int bottom, int width, int height) {
        Drawing.getPen().setColor(Color.DARK_GRAY);
        Drawing.getPen().fillRect(left, bottom, width / 20, height / 20);
    }
}