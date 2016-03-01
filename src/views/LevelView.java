package blockdude.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import blockdude.models.LevelModel;
import blockdude.components.Tile;

public class LevelView extends StackPane {

	private LevelModel model;
	private ScrollPane levelScroll;
	private Canvas levelCanvas;
	private Button menuButton;
	private int tileSize = Tile.TILE_SIZE;

	public LevelView(LevelModel model) {
		this.model = model;
		this.levelScroll = new ScrollPane();

		this.menuButton = new Button("menu");

		this.levelCanvas = renderLevel();
		this.levelScroll.setContent(this.levelCanvas);
		this.levelScroll.setPrefViewportWidth(this.tileSize*12);
		this.levelScroll.setPrefViewportHeight(this.tileSize*8);

		this.getChildren().addAll(this.levelScroll, menuButton);

		this.setAlignment(this.menuButton, Pos.TOP_RIGHT);
		this.setMargin(this.menuButton, new Insets(10, 10, 0, 0));
	}


	public Canvas renderLevel() {
		int canvasWidth  = this.model.getLevelWidth()*this.tileSize;
		int canvasHeight = this.model.getLevelHeight()*this.tileSize;

		System.out.println(canvasWidth+", "+canvasHeight);

		Canvas lCanvas = new Canvas(canvasWidth, canvasHeight);

		GraphicsContext levelGC = lCanvas.getGraphicsContext2D();

		for(int i = 0; i < this.model.getLevelHeight(); i++) {
			for(int j = 0; j < this.model.getLevelWidth(); j++) {
				if(model.getTileObject(i,j) != null) {
					int x = this.model.getLevelWidth() - j - 1;
					int y = this.model.getLevelHeight() - i - 1;
					model.getTileObject(i,j).render(levelGC, x*this.tileSize, y*this.tileSize);
				}
			}
		}

		return lCanvas;
	}

}
