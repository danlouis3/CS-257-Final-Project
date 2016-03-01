package blockdude.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


import blockdude.components.BlockDudeTileObject;
//import what you need to render
public class BlockDudeSpriteTile extends BlockDudeTileObject{
	//public String getType(); old
	public void render(GraphicsContext gc, int xcoord, int ycoord) {
	//make a box in the given space. have it look like a box
		int tileSize = BlockDudeTileObject.TILE_SIZE;
		//change later to look like movable block
		gc.setFill(Color.PINK);
		gc.fillRect(xcoord,ycoord, tileSize, tileSize);
	}
}
