package drawingTool;

import java.util.ArrayList;
import animal.Pig;

public class Scene {
	
    private final ArrayList<Pig> pigs = new ArrayList<>();
    private final int screenWidth, screenHeight;
    
    private int minSize = 100;
    private int maxSize = 200;
    
    private int size;

    public Scene(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    
    public void setPigSize(int size) {
        this.size = size;      
    }
    
    public void updatePigs(int amount, int shirtState) {
        generatePigs(amount, shirtState);
    }
    
    public void clear() {
    	pigs.clear();
    }

    public void draw() {
        for (Pig pig : pigs) {
            pig.draw();
        }
    }

    private void generatePigs(int amount, int shirtState) {
    	
        pigs.clear();
        int attempts = 0;
        
        while (pigs.size() < amount && attempts < amount * 10) {
        	
            attempts++;
            //int size = RandomNumber.between(minSize, maxSize);
            
            int xPosition = RandomNumber.between(maxSize/2, screenWidth - maxSize*15/10);
            int yPosition = RandomNumber.between(maxSize, screenHeight - maxSize/2);
            
            Pig candidate = new Pig(size, size, xPosition, yPosition, shirtState);

            boolean overlaps = false;
            for (Pig existing : pigs) {
                if (candidate.intersects(existing)) {
                    overlaps = true;
                }
            }

            if (!overlaps) {
                pigs.add(candidate);
            }
        }
    }
}
