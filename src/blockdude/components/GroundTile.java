package blockdude.components;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.LinkedList;

import blockdude.components.Tile;
import blockdude.components.Pixel;

//import what you need to render
public class GroundTile extends Tile {
	private boolean hasGrass = false;
	private final Color green = Color.valueOf("#72B561");
	private final Color brown = Color.valueOf("#6D5247");

	public Node render(int x, int y) {
		LinkedList<Node> children = new LinkedList<Node>();
		int size = Tile.TILE_SIZE;
		Rectangle ground = new Rectangle(x*size, y*size, size, size);
		ground.setFill(this.brown);
		children.addLast(ground);

		if(hasGrass) {
			Rectangle grass = new Rectangle(x*size, y*size, size, size*.2);
			grass.setFill(this.green);
			children.addLast(grass);
		}

		return new Group(children);
	}

	public void setHasGrass(boolean val) {
		this.hasGrass = val;
	}
}
