package blockdude.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;
import java.util.LinkedList;

import blockdude.models.LevelModel;
import blockdude.components.Tile;
import blockdude.views.GameMenu;

public class LevelView extends StackPane {

	private LevelModel levelModel;
	private ScrollPane levelScroll;
	private Pane canvas;

	public LevelView(LevelModel lm) {
		this.levelModel = lm;
		this.canvas = new Pane();

		this.levelScroll = new ScrollPane();
		this.levelScroll.setPrefViewportWidth(Tile.TILE_SIZE*12);
		this.levelScroll.setPrefViewportHeight(Tile.TILE_SIZE*8);
		this.levelScroll.setContent(this.canvas);
		this.levelScroll.setPannable(false);
		this.levelScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		this.levelScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		this.getChildren().addAll(this.levelScroll);

		render();

		this.levelScroll.addEventFilter(MouseEvent.MOUSE_PRESSED, (e) -> {
			e.consume();
		});

		this.levelScroll.addEventFilter(ScrollEvent.ANY, (e) -> {
			e.consume();
		});

		lm.addListener( (e) -> render() );
		lm.addTileChangeListener( (e) -> render() );
	}


	public void render() {
		int canvasHeight = this.levelModel.getHeight()*Tile.TILE_SIZE;
		int canvasWidth = this.levelModel.getWidth()*Tile.TILE_SIZE;
		this.canvas.setPrefSize(canvasWidth, canvasHeight);

		List<Node> tiles = new LinkedList<Node>();

		for(int i = 0; i < this.levelModel.getHeight(); i++) {
			for(int j = 0; j < this.levelModel.getWidth(); j++) {
				if(this.levelModel.getTile(i,j) != null) {
					int x = j;
					int y = i;

					tiles.add(this.levelModel.getTile(i,j).render(x,y));
				}
			}
		}

		this.canvas.getChildren().setAll(tiles);
	}

	public Pane getCanvas() {
		return this.canvas;
	}

	public ScrollPane getScrollPane() {
		return this.levelScroll;
	}

	public void setKeyAction(EventHandler<KeyEvent> handler) {
		this.setOnKeyPressed(handler);
	}

}
