package blockdude.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameModel {
	
	private StringProperty levelId;

	public GameModel()	{
		this.levelId = new SimpleStringProperty("1");
	}

	public StringProperty levelIdProperty() {
		return this.levelId;
	}

	public String getLevelId() {
		return this.levelId.getValue();
	}

	public void setLevelId(String val) {
		this.levelId.setValue(val);
	}
}