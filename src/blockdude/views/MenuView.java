package blockdude.views;

import blockdude.models.GameModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;

public class MenuView extends BorderPane{

	public MenuView(GameModel model) {
		GridPane menu = new GridPane();
		Button resetButton = new Button("Rest");
		Button exitButton = new Button("Exit to Main Menu");

		Label levelLabel = new Label(model.getLevelId());
		levelLabel.textProperty().bind(model.levelIdProperty());

		menu.add((new Text("Level: ")), 0, 0);
		menu.add(levelLabel, 0, 1);

		menu.addRow(1, resetButton);
		menu.addRow(2, exitButton);

		Popup menuPopup = new Popup();
		menuPopup.getContent().addAll(menu);

		Button menuButton = new Button();
		menuButton.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("clicked");
				menuPopup.show(MenuView.this, 60, 60);
			}
		});

		this.setAlignment(menuButton, Pos.TOP_RIGHT);

	}
	
}