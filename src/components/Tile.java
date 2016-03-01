package blockdude.components;

import javafx.scene.canvas.GraphicsContext;

public abstract class Tile {
	public static final int TILE_SIZE = 50;
	//public String getType(); no longer necessary?
	public abstract void render(GraphicsContext gc, int xcoord, int ycoord);

	// returns x and y coordinates of upper left (or whatever) of tile 
	//public int[] getLocation();
	//public setLocation(int xcoord, int ycoord);
}
