package blockdude.views;

import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class StartMenu extends BorderPane {
		
	private Button startButton;
	private Button codeButton;

	public StartMenu() {
		this.startButton = new Button("Start");
		this.codeButton = new Button("Code");
		VBox buttonBox = new VBox();
		buttonBox.getChildren().addAll(this.startButton, this.codeButton);
		buttonBox.setAlignment(Pos.CENTER);
		this.setCenter(buttonBox);

		Text text = new Text("Block Dude!");
		text.setFont(new Font("Arial", 50));
		this.setTop(text);
	}	


	public void setStartButtonAction(EventHandler<ActionEvent> handler) {
		this.startButton.setOnAction(handler);
	}

	public void setCodeButtonAction(EventHandler<ActionEvent> handler) {
		this.codeButton.setOnAction(handler);
	}
}