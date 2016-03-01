package blockdude.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import blockdude.models.BlockDudeLevelModel;

public class BlockDudeLevelView extends StackPane {

	private BlockDudeLevelModel model;
	private ScrollPane levelScroll;
	private Canvas levelCanvas;
	private Button menuButton;

	public BlockDudeLevelView(BlockDudeLevelModel model) {
		this.model = model;
		this.levelScroll = new ScrollPane();

		int tileSize = 50;
		int canvasWidth  = this.model.getLevelWidth()*tileSize;
		int canvasHeight = this.model.getLevelHeight()*tileSize;
		
		this.levelCanvas = new Canvas(canvasWidth, canvasHeight);

		GraphicsContext levelGC = this.levelCanvas.getGraphicsContext2D();

		for(int i = 0; i < this.model.getLevelWidth(); i++) {
			for(int j = 0; j < this.model.getLevelHeight(); j++) {
				//this.model.getCellType(i,j);
				
				if(Math.random()<.5 && j>5)
					levelGC.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
			}
		}

		 this.menuButton = new Button("menu");

		this.levelScroll.setContent(this.levelCanvas);
		this.levelScroll.setPrefViewportWidth(tileSize*12);
		this.levelScroll.setPrefViewportHeight(tileSize*12);

		this.getChildren().addAll(this.levelScroll, menuButton);

		this.setAlignment(this.menuButton, Pos.TOP_RIGHT);
		this.setMargin(this.menuButton, new Insets(10, 10, 0, 0));

	}

}
