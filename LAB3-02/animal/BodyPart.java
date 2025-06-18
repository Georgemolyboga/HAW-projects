package animal;

public abstract class BodyPart {
	
    protected int width, height;

    public BodyPart(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void drawAt(int left, int bottom, int width, int height);
}