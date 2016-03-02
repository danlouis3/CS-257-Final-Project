package blockdude.views;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class StartMenu extends GridPane{
		
	private Button startButton;
	private Button codeButton;

	public StartMenu() {
		this.startButton = new Button("Start");
		this.codeButton = new Button("Enter Code");
		VBox buttonBox = new VBox();
		buttonBox.getChildren().addAll(this.startButton, this.codeButton);
		buttonBox.setAlignment(Pos.CENTER);

		Text text = new Text("Block Dude!");
		text.setFont(new Font("Arial", 50));
	}		
}