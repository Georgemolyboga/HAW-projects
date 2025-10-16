package animal;

import java.awt.Color;
import java.awt.Point;

import drawingTool.Drawing;
import drawingTool.RandomNumber;
import drawingTool.LocatedRectangle;

public class Shirt extends PigDecorator{
	
	private int color1, color2, color3;
	
	public Shirt (LocatedRectangle decoration) {
		super(decoration);
	}
	
	@Override
    public void draw() {
		super.getDecoration().draw();
		
		color1  = RandomNumber.between(0, 255);
    	color2  = RandomNumber.between(0, 255);
    	color3  = RandomNumber.between(0, 255);

        Drawing.getPen().setColor(new Color(color1, color2, color3));
        Drawing.getPen().fillArc(address().x + width()/10, address().y + height() / 31*10, width()/15 *10, height()/2, 270, 180);

        Drawing.getPen().setColor(Color.WHITE);
        Drawing.getPen().drawString("Oink!", address().x + width()*5/10, address().y + height() / 18*10);
	}

	@Override public Point address() { 
		return getDecoration().address(); 
	}
	
    @Override public int   width() { 
    	return getDecoration().width();   
    }
    
    @Override public int   height() { 
    	return getDecoration().height();  
    }
}