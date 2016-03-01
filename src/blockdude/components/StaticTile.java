package blockdude.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


import blockdude.components.Tile;
//import what you need to render
public class StaticTile extends Tile {

	//public String getType(); old
	public void render(GraphicsContext gc, int xcoord, int ycoord) {
	//make a box in the given space. have it look like a box
		int tileSize = Tile.TILE_SIZE;
		//change later to look like movable block
		gc.setFill(Color.BLACK);
			gc.fillRect(xcoord,ycoord, tileSize, tileSize);
	}
}
