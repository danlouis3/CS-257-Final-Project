package blockdude.models;

public class BlockDudeLevelModel {

	private int levelHeight,levelWidth, startX,startY;
	private BlockDudeTileObject[][] levelMatrix;
	private int[][] testMatrix;

	public BlockDudeLevelModel(int width, int height, int[][] inputMatrix, int inputX, int inputY) {	
		this.levelWidth = inputMatrix.length;
		this.levelHeight = inputMatrix[0].length;
		this.startX = inputX;
		this.startY = inputY;
		setLevelMatrix(inputMatrix);
		this.testMatrix = new int[7][7];
		for (int i = 0; i < 7; i++){
			for (int j = 0; j <7; j++){
				this.testMatrix[i][j] = Math.random()* 5; 
			}
		}
	}

	private void setLevelMatrix(int[][] testMatrix) { //passedMatrix
		this.levelMatrix = new BlockDudeTileObject[this.levelWidth][this.levelHeight];
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

	public BlockDudeTileObject getTileObject(int xcoord, int ycoord){
		return this.levelMatrix[xcoord][ycoord];
	}
}