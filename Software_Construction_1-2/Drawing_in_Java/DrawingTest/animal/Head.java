package animal;

import java.awt.Color;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Head {
	
    private Eye leftEye, rightEye;
    private Nose nose;
    private Mole mole;
    private Ears leftEar, rightEar;
	private int width, height, x, y, headSize, color1, color2, color3;

    public Head(int width, int height, int color1, int color2, int color3, boolean randomizeColors) {
    	
    	this.color1 = color1;
    	this.color2 = color2;
    	this.color3 = color3;
        
        leftEye = new Eye(color1, color2, color3, randomizeColors);
        rightEye = new Eye(color1, color2, color3, randomizeColors);
        nose = new Nose();
        leftEar = new Ears(color1, color2, color3);
        rightEar = new Ears(color1, color2, color3);
        mole = new Mole();
              
        headSize = width *35/100;
    }

    public void drawAt(int left, int bottom, int width, int height) {
        // Ears 
        leftEar.drawAt(left + width/100, bottom - height*48/100, width, height);
        rightEar.drawAt(left + width*23/100, bottom - height*48/100, width, height);

        // Head
        Drawing.getPen().setColor(new Color(color1, color2, color3));
        Drawing.getPen().fillOval(left, bottom - height/2, headSize, headSize);
        
        x = RandomNumber.between(left + headSize/10, left + headSize/2);
        y = RandomNumber.between(bottom - headSize/2, bottom - headSize);
        
        mole.drawAt(x, y, width, height);

        // Nose
        nose.drawAt(left + width/12, bottom - height*30/100, width, height);
        
        // Eyes
        leftEye.drawAt(left + width*6/100, bottom - height*42/100, width, height);
        rightEye.drawAt(left + width*20/100, bottom - height*42/100, width, height);
    }
}