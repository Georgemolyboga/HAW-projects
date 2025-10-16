package animal;

import java.awt.Point;

import drawingTool.LocatedRectangle;

public abstract class PigDecorator implements LocatedRectangle{
	
	private LocatedRectangle decoration;
	
	public PigDecorator(LocatedRectangle decoration) {
		this.decoration = decoration;
	}
	
	public LocatedRectangle getDecoration() {
		return decoration;
	}
}

