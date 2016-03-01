package blockdude;

import blockdude.models.BlockDudeLevelModel;
import blockdude.views.BlockDudeLevelView;

import javafx.application.Application;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class BlockDudeApplication extends Application {

	private Stage primaryStage;
	private ScrollPane levelLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Block Dude");

		BlockDudeLevelModel model = new BlockDudeLevelModel(40, 12);
		BlockDudeLevelView view = new BlockDudeLevelView(model);

		primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
