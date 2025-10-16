package drawingTool;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import drawingTool.RandomNumber;

public class Background {
    private static final int GRASS_HEIGHT_PERCENTAGE = 40; // Grass will cover 40% of screen
    private static final int MIN_CLOUDS = 3;
    private static final int MAX_CLOUDS = 8;
    private static final int MIN_FLOWERS = 20;
    private static final int MAX_FLOWERS = 40;
    
    private final Color skyColor;
    private final Color grassColor;
    private final int width;
    private final int height;
    private final int grassHeight;
    private final List<Cloud> clouds;
    private final List<Flower> flowers;
    private final Sun sun;

    public Background(int width, int height) {
        this.width = width;
        this.height = height;
        this.grassHeight = height * GRASS_HEIGHT_PERCENTAGE / 100;
        this.skyColor = new Color(135, 206, 250); // Lighter sky blue
        this.grassColor = new Color(50, 205, 50); // Lime green
        this.clouds = new ArrayList<>();
        this.flowers = new ArrayList<>();
        this.sun = new Sun(width - 120, 60, 80);
        generateDecorations();
    }

    private void generateDecorations() {
        generateClouds(RandomNumber.between(MIN_CLOUDS, MAX_CLOUDS));
        generateFlowers(RandomNumber.between(MIN_FLOWERS, MAX_FLOWERS));
    }

    private void generateClouds(int count) {
        clouds.clear();
        for (int i = 0; i < count; i++) {
            int x = RandomNumber.between(-50, width);
            int y = RandomNumber.between(30, height/3);
            int size = RandomNumber.between(40, 100);
            int speed = RandomNumber.between(1, 3);
            clouds.add(new Cloud(x, y, size, speed));
        }
    }

    private void generateFlowers(int count) {
        flowers.clear();
        for (int i = 0; i < count; i++) {
            int x = RandomNumber.between(0, width);
            int y = RandomNumber.between(height - grassHeight, height - 20);
            Color color = new Color(
                RandomNumber.between(200, 255),
                RandomNumber.between(0, 100),
                RandomNumber.between(100, 200)
            );
            flowers.add(new Flower(x, y, color));
        }
    }

    public void draw(Graphics g) {
        drawSky(g);
        sun.draw(g);
        drawClouds(g);
        drawGrass(g);
        drawFlowers(g);
    }

    public void regenerate() {
        generateDecorations();
    }

    private void drawSky(Graphics g) {
        // Sky gradient from top to bottom
        for (int y = 0; y < height - grassHeight; y++) {
            float ratio = (float)y / (height - grassHeight);
            int blue = 250 - (int)(50 * ratio);
            g.setColor(new Color(135, 206, blue));
            g.drawLine(0, y, width, y);
        }
    }

    private void drawGrass(Graphics g) {
        g.setColor(grassColor);
        g.fillRect(0, height - grassHeight, width, grassHeight);
        
        // Grass blades
        g.setColor(new Color(34, 139, 34));
        for (int x = 0; x < width; x += 5) {
            int bladeHeight = RandomNumber.between(5, 15);
            int bladeY = height - grassHeight;
            g.drawLine(x, bladeY, x + RandomNumber.between(-2, 2), bladeY - bladeHeight);
        }
    }

    private void drawClouds(Graphics g) {
        for (Cloud cloud : clouds) {
            cloud.draw(g);
            cloud.move();
            if (cloud.x > width + 100) {
                cloud.x = -100;
            }
        }
    }

    private void drawFlowers(Graphics g) {
        for (Flower flower : flowers) {
            flower.draw(g);
        }
    }

    public int getGrassHeight() {
        return grassHeight;
    }

    // Inner classes for decorative elements
    private class Cloud {
        int x, y, size, speed;
        
        Cloud(int x, int y, int size, int speed) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.speed = speed;
        }
        
        void draw(Graphics g) {
            g.setColor(new Color(255, 255, 255, 200)); // Semi-transparent white
            g.fillOval(x, y, size, size/2);
            g.fillOval(x + size/3, y - size/4, size, size/2);
            g.fillOval(x + size/2, y, size, size/2);
        }
        
        void move() {
            x += speed;
        }
    }

    private class Flower {
        int x, y;
        Color color;
        
        Flower(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
        
        void draw(Graphics g) {
            // Stem
            g.setColor(new Color(0, 100, 0));
            g.drawLine(x, y, x, y + 15);
            
            // Flower head
            g.setColor(color);
            g.fillOval(x - 5, y - 5, 10, 10);
            
            // Center
            g.setColor(Color.YELLOW);
            g.fillOval(x - 2, y - 2, 4, 4);
        }
    }

    private class Sun {
        int x, y, size;
        
        Sun(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
        
        void draw(Graphics g) {
            // Sun rays
            g.setColor(new Color(255, 255, 150));
            for (int i = 0; i < 12; i++) {
                double angle = Math.PI * i / 6;
                int x2 = x + size/2 + (int)(size * Math.cos(angle));
                int y2 = y + size/2 + (int)(size * Math.sin(angle));
                g.drawLine(x + size/2, y + size/2, x2, y2);
            }
            // Sun body
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, size, size);
        }
    }
}