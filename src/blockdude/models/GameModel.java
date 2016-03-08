package blockdude.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import java.text.DecimalFormat;

import blockdude.components.*;

public class GameModel {
	
	private LevelModel currLevel;
	private List<String> levelList;
	private Map<String,String> levelCodes;
	private Integer index;

	public GameModel(String p)	{
		this.levelList = new ArrayList<String>(20);
		this.levelCodes = new HashMap<String,String>();
		DecimalFormat format = new DecimalFormat();
		format.setMinimumIntegerDigits(6);

		File test = new File(p);
		File[] files = (new File(p)).listFiles();
		for(File f: files) {
			if(f.getPath().contains("DS_Store"))
				continue;
			int hash = f.getPath().hashCode();
			String code = format.format(hash).substring(0,6);
			this.levelCodes.put(code, f.getPath());
			this.levelList.add(f.getPath());
		}
		
		Collections.sort(this.levelList);
	}

	public LevelModel getCurrLevel() {
		return this.currLevel;
	}

	public boolean isLevelCode(String code) {
		return levelCodes.containsKey(code);
	}

	public boolean setLevel(String code) throws Exception {
		if(this.levelCodes.containsKey(code)) {
			this.index = this.levelList.indexOf(this.levelCodes.get(code));
			return true;
		}
		else
			return false;
	}

	public void load() {
		if(this.index == null)
			this.index = 0;
		else
			this.index++;
		
		if(this.index < levelList.size())
			this.currLevel = readLevel(this.levelList.get(this.index));
	}

	public void reload() {
		if(this.index != null) 
			this.currLevel = readLevel(this.levelList.get(this.index));
	}

	private static LevelModel readLevel(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String name = reader.readLine();
			Tile[][] grid = new Tile[8][0];

			for(int i = 0; i < 8; i++) {
				String[] row = reader.readLine().split(",");
				grid[i] = new Tile[row.length];
				for(int j = 0; j < row.length; j++) {
					if (Integer.valueOf(row[j]) == 0) {
						grid[i][row.length-j-1] = null;
					}
					else if (Integer.valueOf(row[j]) == 1) {
						grid[i][row.length-j-1] = new StaticTile();
					}
					else if (Integer.valueOf(row[j]) == 2) {
						grid[i][row.length-j-1] = new BlockTile();
					}
					else if (Integer.valueOf(row[j]) == 3) {
						grid[i][row.length-j-1] = new DoorTile();
					}
					else if (Integer.valueOf(row[j]) == 4) {
						grid[i][row.length-j-1] = new PlayerTile();
					}
				}
			}

			return new LevelModel(grid, name);
		}
		catch(IOException e) {
			System.out.println(e);
			return null;
		}
	}
}