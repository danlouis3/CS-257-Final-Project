package blockdude.models;

public class BlockDudeLevelModel {

	private int levelHeight,levelWidth, startX,startY;
	private BlockDudeTileObject[][] levelMatrix;

	public BlockDudeLevelModel(int width, int height, int[][] inputMatrix, int inputX, int inputY) {	
		this.levelWidth = width;
		this.levelHeight = height;
		this.startX = inputX;
		this.startY = inputY;
		setLevelMatrix(inputMatrix);

	}

	private void setLevelMatrix(int[][] passedMatrix) {
		private int width = passedMatrix.length;
		private int height = passedMatrix[0].length;
		this.levelMatrix = new BlockDudeTileObject[width][height];
		for(int row = 0; row < passedMatrix.length; row++) {
			this.levelMatrix.append(BlockDudeTileObject[]);
			for(int column = 0; column < passedMatrix[row].length; column++) {
				if (passedMatrix[row][column] == 0) {
					this.levelMatrix[row][column] = None;
				}
				else if (passedMatrix[row][column] == 1) {
					this.levelMatrix[row][column] = new staticTile();
				}
				else if (passedMatrix[row][column] == 2) {
					this.levelMatrix[row][column] = new boxTile();
				}
				else if (passedMatrix[row][column] == 3) {
					this.levelMatrix[row][column] = new doorTile();
				}
				else if (passedMatrix[row][column] == 4) {
					this.levelMatrix[row][column] = new spriteTile();
				}
			}
		}
	}
	


	public int getLevelHeight() {
		return this.levelHeight;
	}

	public int getLevelWidth() {
		return this.levelWidth;
	}
}