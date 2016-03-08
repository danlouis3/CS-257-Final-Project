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

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
        GameModel model = new GameModel("./blockdude/resources/levels");

		StartMenu startMenu = new StartMenu();
        StackPane viewHolder = new StackPane();
        viewHolder.setPrefSize(12*Tile.TILE_SIZE, 8*Tile.TILE_SIZE);
        viewHolder.getChildren().addAll(startMenu);

        Controller controller = new Controller(viewHolder, model);
        controller.bind(startMenu);

        primaryStage.setTitle("Block Dude");
        primaryStage.setScene(new Scene(viewHolder));
        primaryStage.show();

        //LevelModelFactor modeFactory = new LevelModelFactor(this.levelsPath);
        /*
        Model Model = new Model();
		LevelModel levelModel = new LevelModel(null, "Temporary");
		LevelView levelView = new LevelView(levelModel);
        GameMenu gameMenu = new GameMenu("Temporary");
        Controller Controller = new Controller(levelModel, levelView);
        
        System.out.println(levelView.getHeight());
		primaryStage.setScene(new Scene(levelView));
		primaryStage.show();
        */
	}

	public static void main(String args[]) {
		launch(args);
	}
}



/*
Main Menu -> To Some Level (Either by Code or First) -> End Level Menu -> Next Level
                       |                                                -> Main Menu
                       V 
                       Game Menu -> Main Menu
                                -> Beggining of this Level

(Main Menu)(End Level Menu)
          |
          V
 (Some Level)(Game Menu)



*/
