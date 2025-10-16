package drawingTool;

import java.util.ArrayList;
import animal.Pig;
import animal.Shirt;
import animal.Sunglasses;
import animal.Wings;

public class Scene {
	
    private final ArrayList<LocatedRectangle> pigs = new ArrayList<>();
    private final int screenWidth, screenHeight;
    private Background background;
    private int minSize = 100;
    private int maxSize = 200;
    private int grassLevel;
    
    private int size;

    public Scene(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.background = new Background(screenWidth, screenHeight);
    }
    
    public void setPigSize(int size) {
        this.size = size;      
    }
    
    public void updatePigs(int amount, int shirtState) {
        generatePigs(amount, shirtState, false);
    }
    
    public void clear() {
    	pigs.clear();
    }
    
    public void randomizeColors(int amount, int shirtState) {
    	generatePigs(amount, shirtState, true);
	}

    public void draw() {
        background.draw(Drawing.getPen());
    	for (LocatedRectangle object : pigs) {
    		object.draw();
    	}
    }

    private void generatePigs(int amount, int shirtState, boolean randomizeColors) {
    	
        pigs.clear();
        int attempts = 0;
        
        grassLevel = screenHeight * 6/10;
        
        while (pigs.size() < amount && attempts < amount * 10) {
        	
            attempts++;
            //int size = RandomNumber.between(minSize, maxSize);
            
            int xPosition = RandomNumber.between(maxSize/2, screenWidth - maxSize*15/10);
            int yPosition = RandomNumber.between(maxSize, screenHeight - maxSize/2);
            
            Pig base = new Pig(size, size, xPosition, yPosition, randomizeColors);
            LocatedRectangle candidate;

            switch (shirtState) {              // 0-Random, 1-With shirt, 2-Without shirt, 3-With sunglasses
            case 0 -> {
                int decorationType = RandomNumber.between(0, 2); // 0-no decoration, 1-shirt, 2-sunglasses
                if (decorationType == 1) {
                    candidate = new Shirt(base);
                } else if (decorationType == 2) {
                    candidate = new Sunglasses(base);
                } else {
                    candidate = base;
                }
            }
            case 1 -> candidate = new Shirt(base);
            case 2 -> candidate = new Sunglasses(base);
            case 3 -> candidate = new Sunglasses(new Shirt(base));
            case 4 -> candidate = base;
            default -> candidate = base;
            }
            
            if ((candidate.address().y + size) < grassLevel) {
            	switch (shirtState) {              // 0-Random, 1-With shirt, 2-Without shirt, 3-With sunglasses
                case 0 -> {
                    int decorationType = RandomNumber.between(0, 2); // 0-no decoration, 1-shirt, 2-sunglasses
                    if (decorationType == 1) {
                        candidate = new Wings(new Shirt(base));
                    } else if (decorationType == 2) {
                        candidate = new Wings(new Sunglasses(base));
                    } else {
                        candidate = new Wings(base);
                    }
                }
                case 1 -> candidate = new Wings(new Shirt(base));
                case 2 -> candidate = new Wings(new Sunglasses(base));
                case 3 -> candidate = new Wings(new Sunglasses(new Shirt(base)));
                case 4 -> candidate = base;
                default -> candidate = new Wings(base);
                }
            }
            
            boolean overlaps = false;
            for (LocatedRectangle existing : pigs) {     
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
