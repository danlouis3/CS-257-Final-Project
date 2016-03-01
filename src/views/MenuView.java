package blockdude.views;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import blockdude.models.GameModel;

public class MenuView extends GridPane{

	public MenuView(GameModel model) {
		Button resetButton = new Button("Rest");
		Button exitButton = new Button("Exit to Main Menu");

		Label levelLabel = new Label(model.getLevelId());
		levelLabel.textProperty().bind(model.levelIdProperty());

		this.add((new Text("Level: ")), 0, 0);
		this.add(levelLabel, 0, 1);

		this.addRow(1, resetButton);
		this.addRow(2, exitButton);
	}
}