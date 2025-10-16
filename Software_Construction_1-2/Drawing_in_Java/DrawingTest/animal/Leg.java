package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Leg extends BodyPart {
	
    private Hoof hoof;
    private Mole mole;
    private int color1, color2, color3;

    public Leg(int width, int height, int color1, int color2, int color3) {
    	
        super(width, height);
        hoof = new Hoof();
        mole = new Mole();
        
        this.color1 = color1;
    	this.color2 = color2;
    	this.color3 = color3;
    }

    @Override
    public void drawAt(int left, int bottom, int width, int height) {
    	
        Drawing.getPen().setColor(new Color(color1, color2, color3));
        Drawing.getPen().fillRect(left, bottom, width / 20, height * 3 / 10); // simple pig leg
        
        mole.drawAt(left, bottom + height/5, width, height);
        hoof.drawAt(left, bottom + height*3 / 10, width, height);
    }
}