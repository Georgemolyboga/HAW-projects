package drawingTool;

import java.awt.Graphics;

public class Drawing {

	private static Graphics pen = null;
	
	public static void setPen(Graphics pen) {
		Drawing.pen = pen;
	}
	
	public static Graphics getPen() {
		return Drawing.pen;
	}
}