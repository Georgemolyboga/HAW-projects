package animal;

import java.awt.Color;
import java.awt.Point;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class Wings extends PigDecorator{
    private int width;
    private int height;
    private Color color;

    public Wings(LocatedRectangle decoration) {
    	super(decoration);
    	
    	this.width  = decoration.width();
        this.height = decoration.height();
    }

    @Override
    public void draw() {
        super.getDecoration().draw();
        
        color = new Color(255, 153, 204);
        Drawing.getPen().setColor(color);
        // Left wing
        Drawing.getPen().fillArc(address().x - width/20, address().y + height/3, width/2, height/3, 30, 120);
        // Right wing
        Drawing.getPen().fillArc(address().x + width/3, address().y + height/3, width/2, height/3, 30, 120);
    }

    @Override public Point address() { 
		return getDecoration().address(); 
	}
	
    @Override public int width() { 
    	return getDecoration().width();   
    }
    
    @Override public int height() { 
    	return getDecoration().height();  
    }
}