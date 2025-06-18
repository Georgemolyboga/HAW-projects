package animal;

import java.awt.Color;
import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Body {
    
	int width, height, x, y, event;

    private Shirt shirt;
    private Tail tail;
    private Mole mole;
    private BodyPart legFrontLeft, legFrontRight, legBackLeft, legBackRight;
    private final int shirtCondition;

    public Body(int width, int height, int shirtCondition) {
    	
        this.shirtCondition = shirtCondition;
		this.width = width;
        this.height = height;

        legFrontLeft = new Leg(width, height);
        legFrontRight = new Leg(width, height);
        legBackLeft = new Leg(width, height);
        legBackRight = new Leg(width, height);

        shirt = new Shirt();
        tail = new Tail();
        mole = new Mole();
        
    }

    public void drawAt(int left, int bottom, int width, int height) {
        legFrontLeft.drawAt(left + width *14 / 100, bottom - height / 5, width, height);
        legFrontRight.drawAt(left + width *33 / 100, bottom - height / 4, width, height);
        legBackLeft.drawAt(left + width * 60 / 100, bottom - height / 5, width, height);
        legBackRight.drawAt(left + width * 80 / 100, bottom - height / 4, width, height);

        Drawing.getPen().setColor(Color.PINK);
        Drawing.getPen().fillOval(left, bottom - height * 6 / 10, width, height/2); // pig body
        
        x = RandomNumber.between(left + width/20,left + width*8/10);
        y = RandomNumber.between(bottom - height/5, bottom - height/2);
        
        mole.drawAt(x , y, width, height);
        
        switch (shirtCondition) {
        case 0 -> {                              // RANDOM
            if (RandomNumber.between(0, 1) == 1) {
                shirt.drawAt(left,
                              bottom - height * 6 / 10,
                              width, height);
            }
        }
        case 1 ->                                // WITH SHIRT
            shirt.drawAt(left,
                         bottom - height * 6 / 10,
                         width, height);
        case 2 -> { }                            //WITHOUT SHIRT
        default -> { }
    }
        
        tail.drawAt(left - width / 10, bottom - height * 4 / 10, width, height);
    }
}