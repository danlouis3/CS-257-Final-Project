	package blockdude.components;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import blockdude.components.Tile;
import blockdude.components.BlockTile;

//import what you need to render
public class PlayerTile extends Tile {
	private int orientation = 1;
	private boolean hasBlock = false;

	public Node render(int x, int y) {
		int size = Tile.TILE_SIZE;

		Rectangle rect = new Rectangle(x*size, y*size, size, size);

		int cirX = (x*size + size/2) + (size/4*this.orientation);
		Circle cir = new Circle(cirX, y*size + size*.5, .1*size);
		
		Shape player = Shape.subtract(rect, cir);
		player.setFill(Color.BLUE);

		if(hasBlock) {
			Node block = (new BlockTile()).render(x, y-1);
			return new Group(player, block);
		}
		else {
			return player;
		}
	}

	public void setOrientation(int o) {
		this.orientation = o;
	}

	public int getOrientation() {
		return this.orientation;
	}

	public void setHasBlock(boolean val) {
		this.hasBlock = val;
	}

	public boolean getHasBlock() {
		return this.hasBlock;
	} 
}

