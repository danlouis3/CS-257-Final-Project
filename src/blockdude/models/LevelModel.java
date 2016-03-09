package blockdude.models;

import blockdude.components.Tile;
import blockdude.components.StaticTile;
import blockdude.components.BlockTile;
import blockdude.components.PlayerTile;
import blockdude.components.DoorTile;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.WeakChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;

import java.util.LinkedList;

public class LevelModel {

	private int height, width;
	private ObservableList<Tile> tileList;
	private String name;
	private int playerIndex;
	private int winPos;
	private BooleanProperty hasWon;
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
				if(inputMatrix[i][j] instanceof DoorTile)
					this.winPos = i*this.width + j;
				
				temp.addLast(inputMatrix[i][j]);
			}

		this.tileList = FXCollections.observableArrayList(temp);
		this.hasWon = new SimpleBooleanProperty(false);
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public Tile getTile(int i, int j){
		return this.tileList.get(i*this.width+j);
	}

	public Tile getTile(int k) {
		return this.tileList.get(k);
	}

	public String getName() {
		return this.name;
	}

	public void addTileChangeListener(ListChangeListener<Tile> listener) {
		this.tileList.addListener(listener);
	}

	public BooleanProperty getHasWonProperty() {
		return this.hasWon;
	}	

	public void moveLeft() {
		int k = this.playerIndex;
		PlayerTile player = (PlayerTile)(getTile(k));
		player.setOrientation(-1);

		int dx = 0;
		if(leftIsValid(k)) 
			dx = 1;
		
		move(k, k + (-1 * dx));
		drop();
	}

	public void moveRight() {
		int k = this.playerIndex;
		PlayerTile player = (PlayerTile)(getTile(k));
		player.setOrientation(1);

		int dx = 0;
		if(rightIsValid(k)) {
			dx = 1;
		}
		
		move(k, k + (1 * dx));
		drop();
	}

	public void moveUp() {
		int k = this.playerIndex;
		PlayerTile player = (PlayerTile)(getTile(k));
		int o = player.getOrientation();

		if(upIsValid(k, o)) 
			move(k, k + o - this.width);
		
	}

	public void block() {
		int k = this.playerIndex;
		PlayerTile player = (PlayerTile)(getTile(k));
		int o = player.getOrientation();

		if(	(o == -1 && k%this.width != 0) || 
			(o ==  1 && (k+1)%this.width != 0)) {
			if(!player.getHasBlock()) {
				if(getTile(k+o*1) instanceof BlockTile) {
					this.tileList.set(k+o*1, null);
					player.setHasBlock(true);
				}
			}
			else {
				if(isEmpty(getTile(k+o*1))) {
					this.tileList.set(k+o*1, new BlockTile());
					player.setHasBlock(false);
				}
			}
		}

		move(k, k);
	}

	private void drop() {
		int k = this.playerIndex;
		PlayerTile player = (PlayerTile)(getTile(k));

		int dy = 0;
		while(k + (dy + 1) * this.width < this.tileList.size() &&
			  isEmpty(getTile(k + (dy + 1) * this.width))) 
			dy++;

		if(dy != 0) 
			move(k, k + dy * this.width);
	}

	private void move(int a, int b) {
		Tile tile = getTile(a);
		if(tile instanceof PlayerTile) {
			this.playerIndex = b;
			checkWin();
		}

		this.tileList.set(a, null);
		this.tileList.set(b, tile);
	}

	private boolean leftIsValid(int k) {
		if(k%this.width == 0)
			return false;

		return isEmpty(getTile(k-1));
	}

	private boolean rightIsValid(int k) {
		if((k+1)%this.width == 0)
			return false;

		return isEmpty(getTile(k+1));
	}

	private boolean upIsValid(int k, int o) {
		if(k < this.width)
			return false;

		return 	getTile(k+o) != null &&
				getTile(k+o - this.width) == null;
	}

	private void checkWin() {
		if(this.playerIndex == this.winPos) 
			this.hasWon.set(true);
	}

	private boolean isEmpty(Tile tile) {
		return tile == null || tile instanceof DoorTile;
	}
}