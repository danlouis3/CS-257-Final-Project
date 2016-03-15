package blockdude;

import blockdude.models.LevelModel;
import blockdude.views.LevelView;
import blockdude.views.StartMenu;
import blockdude.models.GameModel;
import blockdude.controllers.Controller;
import blockdude.components.Tile;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * This Class serves as the entry point for the game.
 *
 * @author Phineas Callahan, Daniel Hamalainen, Sam West
 */
public class MainApp extends Application {

    /**
     * The start function initializes the Model, View, and Controller components of BlockDude.
     */
	@Override
	public void start(Stage primaryStage) {
        //The GameModel will hold the state of the BlockDude game
        GameModel model = new GameModel("./blockdude/resources/levels");

		StartMenu startMenu = new StartMenu();
        StackPane viewHolder = new StackPane();

        Controller controller = new Controller(viewHolder, model);
        controller.bind(startMenu);

        viewHolder.setPrefSize(12*Tile.TILE_SIZE, 8*Tile.TILE_SIZE);
        viewHolder.getChildren().addAll(startMenu);
        viewHolder.getStylesheets().add("blockdude/resources/css/style.css");

        primaryStage.setTitle("Block Dude");
        primaryStage.setScene(new Scene(viewHolder));
        primaryStage.show();
	}

    public static void main(String args[]) {
		launch(args);
	}
}
