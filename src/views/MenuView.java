package blockdude.views;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MenuView extends GridPane{

	private IntegerProperty currLevel;

	public MenuView(GameModel model) {
		Button resetButton = new Button("Rest");
		Button exitButton = new Button("Exit to Main Menu");

		Label levelLabel = new Label(model.getLevelId());
		levelLabel.bind(model.getLevelIdProperty);

		this.add((new Text("Level: ")), 0, 0);
		this.add(levelLabel, 0, 1);

		this.addRow(resetButton, 1);
		this.addRow(exitButton, 2);
	}
}