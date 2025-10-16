package animal;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Body {
    
	private int width, height, x, y, event, color1, color2, color3;
    private Tail tail;
    private Mole mole;
    private BodyPart legFrontLeft, legFrontRight, legBackLeft, legBackRight;

    public Body(int width, int height, int color1, int color2, int color3) {
    	
		this.width = width;
        this.height = height;
        this.color1 = color1;
    	this.color2 = color2;
    	this.color3 = color3;

        legFrontLeft = new Leg(width, height, color1, color2, color3);
        legFrontRight = new Leg(width, height, color1, color2, color3);
        legBackLeft = new Leg(width, height, color1, color2, color3);
        legBackRight = new Leg(width, height, color1, color2, color3);
        tail = new Tail(color1, color2, color3);
        mole = new Mole();  
    }

    public void drawAt(int left, int bottom, int width, int height) {
    	
        legFrontLeft.drawAt(left + width *14 / 100, bottom - height / 5, width, height);
        legFrontRight.drawAt(left + width *33 / 100, bottom - height / 4, width, height);
        legBackLeft.drawAt(left + width * 60 / 100, bottom - height / 5, width, height);
        legBackRight.drawAt(left + width * 80 / 100, bottom - height / 4, width, height);

        Drawing.getPen().setColor(new Color(color1, color2, color3));
        Drawing.getPen().fillOval(left, bottom - height * 6 / 10, width, height/2); // pig body
        
        x = RandomNumber.between(left + width/20,left + width*8/10);
        y = RandomNumber.between(bottom - height/5, bottom - height/2);
        
        mole.drawAt(x , y, width, height);
        tail.drawAt(left - width / 10, bottom - height * 4 / 10, width, height);
    }
}