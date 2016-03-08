package blockdude.components;

import javafx.scene.Node;

public abstract class Tile {
	public final static int TILE_SIZE = 70;
	public abstract Node render(int x, int y);
}
