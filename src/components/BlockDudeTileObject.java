package blockdude.components;
public abstract class BlockDudeTileObject {
	public static final int TILE_SIZE = 10;
	//public String getType(); no longer necessary?
	public void render(GraphicsContext gc, int xcoord, int ycoord);
	// returns x and y coordinates of upper left (or whatever) of tile 
	public int[] getLocation();
	public setLocation(int xcoord, int ycoord);


}
