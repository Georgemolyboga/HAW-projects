package animal;

import java.awt.Color;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Head {
    private Eye leftEye, rightEye;
    private Nose nose;
    private Mole mole;
    private Ears leftEar, rightEar;
    
	int width, height, x, y, headSize;

    public Head(int width, int height) {
        
        leftEye = new Eye();
        rightEye = new Eye();
        nose = new Nose();
        leftEar = new Ears();
        rightEar = new Ears();
        mole = new Mole();
              
        headSize = width *35/100;
    }

    public void drawAt(int left, int bottom, int width, int height) {
        // Ears 
        leftEar.drawAt(left + width/100, bottom - height*48/100, width, height);
        rightEar.drawAt(left + width*23/100, bottom - height*48/100, width, height);

        // Head
        Drawing.getPen().setColor(Color.PINK);
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