package blockdude.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import blockdude.models.LevelModel;
import blockdude.components.Tile;
//import blockdude.views.InGamePopup;

public class LevelView extends StackPane {

	private LevelModel model;
	private InGameMenu menu;
	private ScrollPane levelScroll;
	private Canvas canvas;
	private Button menuButton;
	private int tileSize = Tile.TILE_SIZE;

	public LevelView(LevelModel model) {
		this.model = model;

		int canvasHeight = this.model.getLevelHeight()*this.tileSize;
		int canvasWidth = this.model.getLevelWidth()*this.tileSize;
		this.canvas = new Canvas(canvasWidth, canvasHeight);
		renderCanvas();

		this.levelScroll = new ScrollPane();
		this.levelScroll.setPrefViewportWidth(this.tileSize*12);
		this.levelScroll.setPrefViewportHeight(this.tileSize*8);
		this.levelScroll.setContent(this.canvas);
		this.levelScroll.setPannable(false);
		this.levelScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		this.menu = new InGameMenu(model.getName());
		this.menu.managedProperty().bind(model.menuVisibleProperty());
		this.menu.visibleProperty().bind(model.menuVisibleProperty());

		this.menuButton = new Button("Menu");

		this.getChildren().addAll(this.levelScroll, this.menuButton, this.menu);
		StackPane.setAlignment(this.menuButton, Pos.TOP_RIGHT);
		StackPane.setMargin(this.menuButton, new Insets(10, 10, 0, 0));

		StackPane.setAlignment(this.menu, Pos.CENTER);

	}


	public void renderCanvas() {
		System.out.println(canvas.getHeight());
		GraphicsContext levelGC = this.canvas.getGraphicsContext2D();

		for(int i = 0; i < this.model.getLevelHeight(); i++) {
			for(int j = 0; j < this.model.getLevelWidth(); j++) {
				if(model.getTileObject(i,j) != null) {
					int x =  this.model.getLevelWidth() - j - 1;
					int y = this.model.getLevelHeight() - i - 1;

					model.getTileObject(i,j).render(levelGC, x*this.tileSize, y*this.tileSize);
				}
			}
		}
		System.out.println(canvas.getHeight());
	}

	public Button getMenuButton() {
		return this.menuButton;
	}

	public Canvas getCanvas() {
		return this.canvas;
	}

	public ScrollPane getScrollPane() {
		return this.levelScroll;
	}

}
