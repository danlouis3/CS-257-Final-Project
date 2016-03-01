package blockdude.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//import what you need to render
public class boxTile extends BlockDudeTileObjectInterface{
	private 
	//public String getType(); old
	public void render(GraphicsContext gc, int xcoord, int ycoord);
	//make a box in the given space. have it look like a box
		int tileSize = BlockDudeTileObjectInterface.TILE_SIZE;
		//change later to look like movable block
		gc.setFill(Color.magenta);
		gc.fillRect(xcoord,ycoord,this.tileSize,this.tileSize);

	// returns x and y coordinates of upper left (or whatever) of tile 
	public int getLocation();
	public void setLocation();
}