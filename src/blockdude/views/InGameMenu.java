package blockdude.views;

import blockdude.models.GameModel;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

public class InGameMenu extends BorderPane {

	public InGameMenu(String name) {
		Button resetButton = new Button("Reset");
		Button exitButton = new Button("Main Menu");
		HBox buttonBox = new HBox();
		buttonBox.setSpacing(15);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.getChildren().addAll(resetButton, exitButton);
		this.setBottom(buttonBox);
		this.setAlignment(buttonBox, Pos.CENTER);

		Label levelName = new Label(name);
		levelName.setFont(new Font("Arial", 25));
		this.setTop(levelName);
		this.setAlignment(levelName, Pos.CENTER);

		this.setStyle("-fx-background-color : white");
		this.setPadding(new Insets(10,10,20,10));

		this.setMaxSize(300, 230);
	}
}