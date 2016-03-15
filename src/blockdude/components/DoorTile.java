package blockdude.components;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import blockdude.components.Tile;

//import what you need to render
public class DoorTile extends Tile {

	public Node render(int x, int y) {
		int size = Tile.TILE_SIZE;
		Rectangle rect = new Rectangle(x*size+size/6, y*size, 4*size/6, size);
		rect.setFill(Color.valueOf("#E85F5C"));

		Circle circ = new Circle(x*size+.66*size, y*size+.5*size, size/12);
		circ.setFill(Color.BROWN);

		return new Group(rect, circ);
	}
}
