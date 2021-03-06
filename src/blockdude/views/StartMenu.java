package blockdude.views;

import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;	
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StartMenu extends BorderPane {
		
	private Button startButton;
	//private Button codeButton;

	public StartMenu() {
		this.startButton = new Button("Start");
		this.startButton.setMinWidth(200);

		//this.codeButton = new Button("Code");
		//this.codeButton.setMinWidth(200);

		VBox buttonBox = new VBox();
		buttonBox.getChildren().addAll(this.startButton/**, this.codeButton**/);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(18);

		this.setCenter(buttonBox);

		Label text = new Label("Block Dude!");
		BorderPane.setAlignment(text, Pos.TOP_CENTER);
		BorderPane.setMargin(text, new Insets(40,0,0,0));

		this.setTop(text);

		this.getStyleClass().add("start-menu");
		this.getStyleClass().add("menu");
	}	


	public void setStartButtonAction(EventHandler<ActionEvent> handler) {
		this.startButton.setOnAction(handler);
	}

	/**
	public void setCodeButtonAction(EventHandler<ActionEvent> handler) {
		this.codeButton.setOnAction(handler);
	}
	 **/
}