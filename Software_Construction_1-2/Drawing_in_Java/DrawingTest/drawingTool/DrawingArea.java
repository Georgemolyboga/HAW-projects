package drawingTool;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
    private Scene scene;

    public DrawingArea(int width, int height) {
    	
    	super.setPreferredSize(new Dimension(width, height));
        scene = new Scene(width, height);
    }
    
    public Scene getScene() {
        return scene;
    }
	
	protected void paintComponent(Graphics pen) {
		
		super.paintComponent(pen);
		
		Drawing.setPen(pen);
	
		scene.draw();	
	}
}