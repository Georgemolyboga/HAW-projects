package animal;

import java.awt.Color;
import java.awt.Point;
import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class Pig implements LocatedRectangle {
    private Body body;
    private Head head;
    private Wings wings;  // New wings attribute
    private int x, y, boundWidth, boundHeight, width, height;
    private boolean hasWings;  // Flag to track if pig has wings
    private Color wingColor = new Color(255, 200, 220);  // Light pink wings
    
    public Pig(int width, int height) {
        this(width, height, 0, 0, 0, false);
    }

    public Pig(int width, int height, int x, int y, int shirtCondition) {
        this(width, height, x, y, shirtCondition, false);
    }

    // New constructor with wings parameter
    public Pig(int width, int height, int x, int y, int shirtCondition, boolean hasWings) {
        this.width = width;
        this.height = height;
        this.hasWings = hasWings;
        this.body = new Body(width, height, shirtCondition);
        this.head = new Head(width, height);
        
        if (hasWings) {
            this.wings = new Wings(width, height);
        }
        
        setPosition(x, y);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        this.boundWidth = width * 15 / 10;
        this.boundHeight = height * 12 / 10;
    }

    public void drawAt(int left, int bottom) {
        body.drawAt(left, bottom, width, height);
        head.drawAt(left + width*85/100, bottom - height*3/10, width, height);
        
        // Draw wings if pig has them
        if (hasWings && wings != null) {
            wings.drawAt(left + width/2, bottom - height/4);
        }
    }
    
    @Override
    public void draw() {
        drawAt(x, y);
    }

    // Method to add/remove wings
    public void setWings(boolean hasWings) {
        this.hasWings = hasWings;
        if (hasWings && wings == null) {
            wings = new Wings(width, height);
        }
    }

    public boolean hasWings() {
        return hasWings;
    }

    @Override
    public Point address() {
        int xPosition = x - boundWidth / 10;
        int yPosition = y - boundHeight * 8 / 10;
        return new Point(xPosition, yPosition);
    }

    @Override
    public int width() {
        return boundWidth;
    }

    @Override
    public int height() {
        return boundHeight;
    }
}
