package blockdude.views;

import javafx.scene.control.ScrollPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import blockdude.models.BlockDudeLevelModel;

public class BlockDudeLevelView extends ScrollPane {

	private BlockDudeLevelModel model;
	private Canvas levelCanvas;

	public BlockDudeLevelView(BlockDudeLevelModel model) {
		this.model = model;


		int tileSize = 10;
		int canvasWidth  = this.model.getLevelWidth()*tileSize;
		int canvasHeight = this.model.getLevelHeight()*tileSize;

		this.levelCanvas = new Canvas(canvasWidth, canvasHeight);

		GraphicsContext levelGC = this.levelCanvas.getGraphicsContext2D();

		for(int i = 0; i < this.model.getLevelWidth(); i++) {
			for(int j = 0; j < this.model.getLevelHeight(); j++) {
				//this.model.getCellType(i,j);
				
				if(Math.random()<.5)
					levelGC.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
			}
		}

		this.setPrefSize(200, 200);
		this.setContent(this.levelCanvas);
	}

}
