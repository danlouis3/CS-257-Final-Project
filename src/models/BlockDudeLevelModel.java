package blockdude.models;

public class BlockDudeLevelModel {

	private int levelHeight,levelWidth;

	public BlockDudeLevelModel(int width, int height) {	
		this.levelWidth = width;
		this.levelHeight = height;
	}


	public int getLevelHeight() {
		return this.levelHeight;
	}

	public int getLevelWidth() {
		return this.levelWidth;
	}
}