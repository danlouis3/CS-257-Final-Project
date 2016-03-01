package blockdude.models;

import blockdude.components.Tile;
import blockdude.components.StaticTile;
import blockdude.components.BlockTile;
import blockdude.components.PlayerTile;
import blockdude.components.DoorTile;

public class LevelModel {

	private int levelHeight,levelWidth, startX,startY;
	private Tile[][] levelMatrix;
	//private int[][] testMatrix;

	public LevelModel(int[][] inputMatrix, int inputX, int inputY) {	
		this.levelWidth = inputMatrix[0].length;
		this.levelHeight = inputMatrix.length;
		this.startX = inputX;
		this.startY = inputY;
		//this.testMatrix = new int[24][12];
		/*for (int i = 0; i < 24; i++){
			for (int j = 0; j < 12; j++){
				this.testMatrix[i][j] = (int)(Math.random()*5); 
			}
		}*/

		setLevelMatrix(inputMatrix);
	}

	private void setLevelMatrix(int[][] testMatrix) { //passedMatrix
		this.levelMatrix = new Tile[this.levelHeight][this.levelWidth];
		for(int row = 0; row < this.levelHeight; row++) {
			for(int col = 0; col < this.levelWidth; col++) {
				if (testMatrix[row][col] == 0) {
					this.levelMatrix[row][col] = null;
				}
				else if (testMatrix[row][col] == 1) {
					this.levelMatrix[row][col] = new StaticTile();
				}
				else if (testMatrix[row][col] == 2) {
					this.levelMatrix[row][col] = new BlockTile();
				}
				else if (testMatrix[row][col] == 3) {
					this.levelMatrix[row][col] = new DoorTile();
				}
				else if (testMatrix[row][col] == 4) {
					this.levelMatrix[row][col] = new PlayerTile();
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

	public Tile getTileObject(int xcoord, int ycoord){
		return this.levelMatrix[xcoord][ycoord];
	}
}