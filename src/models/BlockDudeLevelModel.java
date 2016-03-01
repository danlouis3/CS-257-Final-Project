package blockdude.models;

import blockdude.components.BlockDudeTileObject;
import blockdude.components.BlockDudeStaticTile;
import blockdude.components.BlockDudeBoxTile;
import blockdude.components.BlockDudeSpriteTile;
import blockdude.components.BlockDudeDoorTile;

public class BlockDudeLevelModel {

	private int levelHeight,levelWidth, startX,startY;
	private BlockDudeTileObject[][] levelMatrix;
	private int[][] testMatrix;

	public BlockDudeLevelModel(int width, int height, int[][] inputMatrix, int inputX, int inputY) {	
		this.levelWidth = 24; //inputMatrix.length;
		this.levelHeight = 12;  //inputMatrix[0].length;
		this.startX = inputX;
		this.startY = inputY;
		this.testMatrix = new int[24][12];
		for (int i = 0; i < 24; i++){
			for (int j = 0; j < 12; j++){
				this.testMatrix[i][j] = (int)(Math.random()*5); 
			}
		}

		setLevelMatrix(testMatrix);
	}

	private void setLevelMatrix(int[][] testMatrix) { //passedMatrix
		this.levelMatrix = new BlockDudeTileObject[this.levelWidth][this.levelHeight];
		for(int row = 0; row < testMatrix.length; row++) {
			for(int column = 0; column < testMatrix[row].length; column++) {
				if (testMatrix[row][column] == 0) {
					this.levelMatrix[row][column] = null;
				}
				else if (testMatrix[row][column] == 1) {
					this.levelMatrix[row][column] = new BlockDudeStaticTile();
				}
				else if (testMatrix[row][column] == 2) {
					this.levelMatrix[row][column] = new BlockDudeBoxTile();
				}
				else if (testMatrix[row][column] == 3) {
					this.levelMatrix[row][column] = new BlockDudeDoorTile();
				}
				else if (testMatrix[row][column] == 4) {
					this.levelMatrix[row][column] = new BlockDudeSpriteTile();
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