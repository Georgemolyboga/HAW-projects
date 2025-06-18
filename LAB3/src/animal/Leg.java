package animal;

import java.awt.Color;
import drawingTool.Drawing;

public class Leg extends BodyPart {
    private Hoof hoof;
    private Mole mole;

    public Leg(int width, int height) {
        super(width, height);
        hoof = new Hoof();
        mole = new Mole();
    }

    @Override
    public void drawAt(int left, int bottom, int width, int height) {
        Drawing.getPen().setColor(Color.PINK);
        Drawing.getPen().fillRect(left, bottom, width / 20, height * 3 / 10); // simple pig leg
        
        mole.drawAt(left, bottom + height/5, width, height);

        // Hoof
        hoof.drawAt(left, bottom + height*3 / 10, width, height);
    }
}