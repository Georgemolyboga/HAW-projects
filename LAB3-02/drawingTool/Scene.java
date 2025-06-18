package drawingTool;

import java.util.ArrayList;
import animal.Pig;
import drawingTool.RandomNumber;

public class Scene {
    private final ArrayList<Pig> pigs = new ArrayList<>();
    private final int screenWidth, screenHeight;
    private Background background;
    private int minSize = 100;
    private int maxSize = 200;
    private int size;
    private boolean randomSizes = false;

    public Scene(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.background = new Background(screenWidth, screenHeight);
    }

    public void setPigSize(int size) {
        this.size = size;
        this.randomSizes = false; // Using fixed size
    }

    public void setRandomSizes(boolean random) {
        this.randomSizes = random;
    }

    public void updatePigs(int amount, int shirtState) {
        generatePigs(amount, shirtState);
    }

    public void clear() {
        pigs.clear();
    }

    public void draw() {
        background.draw(Drawing.getPen());
        for (Pig pig : pigs) {
            pig.draw();
        }
    }

    private boolean isInSky(int yPosition) {
        return yPosition < (screenHeight - background.getGrassHeight());
    }

    private void generatePigs(int amount, int shirtState) {
        background.regenerate(); // Regenerate background elements
        pigs.clear();
        int attempts = 0;
        final int maxAttempts = amount * 10;

        while (pigs.size() < amount && attempts < maxAttempts) {
            attempts++;
            
            // Determine pig size
            int currentSize = randomSizes ? RandomNumber.between(minSize, maxSize) : size;
            
            // Random position within bounds
            int xPosition = RandomNumber.between(currentSize/2, screenWidth - currentSize*15/10);
            int yPosition = RandomNumber.between(currentSize, screenHeight - currentSize);
            
            // Check if pig should have wings
            boolean inSky = isInSky(yPosition);
            
            // Create pig with appropriate wings
            Pig candidate = new Pig(currentSize, currentSize, xPosition, yPosition, shirtState, inSky);

            // Check for overlaps
            if (!checkOverlap(candidate)) {
                pigs.add(candidate);
                System.out.println("Added " + (inSky ? "flying" : "ground") + 
                                 " pig at (" + xPosition + ", " + yPosition + ")");
            }
        }
    }

    private boolean checkOverlap(Pig candidate) {
        for (Pig existing : pigs) {
            if (candidate.intersects(existing)) {
                return true;
            }
        }
        return false;
    }

    // Getters
    public ArrayList<Pig> getPigs() {
        return pigs;
    }

    public Background getBackground() {
        return background;
    }
}