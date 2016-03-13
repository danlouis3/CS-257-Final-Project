package blockdude.components;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Pixel extends Rectangle{
	public final static int PIXEL_SIZE = 7;

	public Pixel(double x, double y, Color c) {
		super(x, y, PIXEL_SIZE, PIXEL_SIZE);
		this.setFill(c);
	}
}