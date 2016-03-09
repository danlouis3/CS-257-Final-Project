package blockdude.views;

import blockdude.models.GameModel;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

public class GameMenu extends BorderPane {

	public GameMenu(String name) {
		Button resetButton = new Button("Reset");
		Button exitButton = new Button("Main Menu");
		Label levelName = new Label(name);
		levelName.setFont(new Font("Arial", 25));	

		VBox buttonBox = new VBox();
		buttonBox.setSpacing(15);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(resetButton, exitButton, levelName);
		BorderPane.setAlignment(buttonBox, Pos.CENTER);

		Button menuButton = new Button("Menu");
		BorderPane.setAlignment(menuButton, Pos.TOP_RIGHT);
		BorderPane.setMargin(menuButton, new Insets(10, 10, 0, 0));
		
		this.setStyle("-fx-background-color : white");
		this.setPadding(new Insets(10,10,20,10));
	}
}