package animal;

import java.awt.Color;
import java.awt.Point;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

public class Sunglasses extends PigDecorator {
    
    public Sunglasses(LocatedRectangle decoration) {
        super(decoration);
    }
    
    @Override
    public void draw() {
        super.getDecoration().draw();
        
        int lensWidth = width() * 15/100;
        int lensHeight = height() * 5/100;
        int bridgeWidth = width() * 3/100;
        int yPosition = address().y + height() * 22/100; 
        
        Drawing.getPen().setColor(new Color(30, 30, 30, 200)); 
        
        // Left lens (positioned over left eye)
        Drawing.getPen().fillRoundRect(
            address().x + width() * 60/100, 
            yPosition, 
            lensWidth, 
            lensHeight, 
            5, 5
        );
        
        // Right lens (positioned over right eye)
        Drawing.getPen().fillRoundRect(
            address().x + width() * 78/100, 
            yPosition, 
            lensWidth, 
            lensHeight, 
            5, 5
        );
        
        // Bridge between lenses
        Drawing.getPen().fillRect(
            address().x + width() * 75/100, 
            yPosition, 
            bridgeWidth, 
            lensHeight
        );
        
        // Frame around lenses (optional)
        Drawing.getPen().setColor(Color.BLACK);
        Drawing.getPen().drawRoundRect(
            address().x + width() * 60/100, 
            yPosition, 
            lensWidth, 
            lensHeight, 
            5, 5
        );
        Drawing.getPen().drawRoundRect(
            address().x + width() * 78/100, 
            yPosition, 
            lensWidth, 
            lensHeight, 
            5, 5
        );
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