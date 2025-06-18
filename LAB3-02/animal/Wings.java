package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Wings {
    private int width;
    private int height;
    private Color color;

    public Wings(int width, int height) {
        this.width = width;
        this.height = height;
        this.color = new Color(255, 200, 220); // Light pink wings
    }

    public void drawAt(int left, int bottom) {
        Drawing.getPen().setColor(color);
        Drawing.getPen().fillArc(left - width/2, bottom - height/5, width/2, height/3, 30, 120);
        Drawing.getPen().fillArc(left + width/8, bottom - height/5, width/2, height/3, 30, 120);
    }
}