package blockdude.models;

import blockdude.components.BlockDudeTileObject;
import blockdude.components.BlockDudeStaticTile;
import blockdude.components.BlockDudeBoxTile;
import blockdude.components.BlockDudeSpriteTile;
import blockdude.components.BlockDudeDoorTile;

public class BlockDudeLevelModel {

	private int levelHeight,levelWidth, startX,startY;
	private BlockDudeTileObject[][] levelMatrix;
	//private int[][] testMatrix;

	public BlockDudeLevelModel(int[][] inputMatrix, int inputX, int inputY) {	
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
		this.levelMatrix = new BlockDudeTileObject[this.levelHeight][this.levelWidth];
		for(int row = 0; row < this.levelHeight; row++) {
			for(int col = 0; col < this.levelWidth; col++) {
				if (testMatrix[row][col] == 0) {
					this.levelMatrix[row][col] = null;
				}
				else if (testMatrix[row][col] == 1) {
					this.levelMatrix[row][col] = new BlockDudeStaticTile();
				}
				else if (testMatrix[row][col] == 2) {
					this.levelMatrix[row][col] = new BlockDudeBoxTile();
				}
				else if (testMatrix[row][col] == 3) {
					this.levelMatrix[row][col] = new BlockDudeDoorTile();
				}
				else if (testMatrix[row][col] == 4) {
					this.levelMatrix[row][col] = new BlockDudeSpriteTile();
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