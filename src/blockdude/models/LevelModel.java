package blockdude.models;

import blockdude.components.Tile;
import blockdude.components.StaticTile;
import blockdude.components.BlockTile;
import blockdude.components.PlayerTile;
import blockdude.components.DoorTile;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

import java.util.LinkedList;

public class LevelModel extends SimpleObjectProperty {

	private int height, width;
	private ObservableList<Tile> tileList;
	private String name;
	private int playerIndex;
	//private int[][] testMatrix;

	public LevelModel(Tile[][] inputMatrix, String name) {	
		this.width  = inputMatrix[0].length;
		this.height = inputMatrix.length;
		this.name = name;

		LinkedList<Tile> temp = new LinkedList<Tile>();
		for(int i = 0; i < this.height; i++)
			for(int j = 0; j < this.width; j++) {
				if(inputMatrix[i][j] instanceof PlayerTile) 
					playerIndex = i*this.width + j;
				
				temp.addLast(inputMatrix[i][j]);
			}

		this.tileList = FXCollections.observableArrayList(temp);
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public Tile getTile(int i, int j){
		return tileList.get(i*this.width+j);
	}

	public String getName() {
		return this.name;
	}

	public void addTileChangeListener(ListChangeListener<Tile> listener) {
		this.tileList.addListener(listener);
	}

	public void moveLeft() {
		int k = this.playerIndex;
		if(leftIsValid(k)) {
			this.tileList.set(k - 1, this.tileList.get(k));
			this.tileList.set(k, null);
			this.playerIndex -= 1;
		}
	}

	public void moveRight() {
		int k = this.playerIndex;
		if(rightIsValid(k)) {
			this.tileList.set(k + 1, this.tileList.get(k));
			this.tileList.set(k, null);
			this.playerIndex += 1;
		}
	}

	private boolean leftIsValid(int k) {
		if(k%this.width == 0)
			return false;

		return this.tileList.get(k-1) == null;
	}

	private boolean rightIsValid(int k) {
		if((k+1)%this.width == 0)
			return false;

		return this.tileList.get(k+1) == null;
	}
}