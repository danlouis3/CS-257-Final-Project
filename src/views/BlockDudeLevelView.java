package blockdude.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import blockdude.models.BlockDudeLevelModel;
import blockdude.components.BlockDudeTileObject;

public class BlockDudeLevelView extends StackPane {

	private BlockDudeLevelModel model;
	private ScrollPane levelScroll;
	private Canvas levelCanvas;
	private Button menuButton;
	private int tileSize = BlockDudeTileObject.TILE_SIZE;

	public BlockDudeLevelView(BlockDudeLevelModel model) {
		this.model = model;
		this.levelScroll = new ScrollPane();

		this.menuButton = new Button("menu");

		this.levelCanvas = renderLevel();
		this.levelScroll.setContent(this.levelCanvas);
		this.levelScroll.setPrefViewportWidth(this.tileSize*12);
		this.levelScroll.setPrefViewportHeight(this.tileSize*12);

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

		for(int i = 0; i < this.model.getLevelWidth(); i++) {
			for(int j = 0; j < this.model.getLevelHeight(); j++) {
				if(model.getTileObject(i,j) != null) {
					model.getTileObject(i,j).render(levelGC, i*this.tileSize, j*this.tileSize);
					System.out.println("HEY BABE");
				}
			}
		}

		return lCanvas;
	}

}
