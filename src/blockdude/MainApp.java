package blockdude;

import blockdude.models.LevelModel;
import blockdude.views.LevelView;
//import blockdude.views.MenuView;
import blockdude.models.GameModel;
import blockdude.controllers.LevelController;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainApp extends Application {

    private String levelsPath = "./resources/level/";
	private Stage primaryStage;
    public int levelOneMatrix[][];

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Block Dude");

        //LevelModelFactor modeFactory = new LevelModelFactor(this.levelsPath);
        int[][] levelOneMatrix =  { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                                    {1,3,0,0,1,0,0,0,1,0,2,0,1,0,2,0,4,0,0,1},
                                    {1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1},
                                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
        
        GameModel gameModel = new GameModel();
		LevelModel levelModel = new LevelModel(levelOneMatrix, 0, 0);
		LevelView levelView = new LevelView(levelModel);
        LevelController levelController = new LevelController(levelModel, levelView);

        System.out.println(levelView.getHeight());
		primaryStage.setScene(new Scene(levelView));
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
