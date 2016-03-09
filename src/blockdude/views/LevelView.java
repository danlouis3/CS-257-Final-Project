package blockdude.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;
import java.util.LinkedList;

import blockdude.models.LevelModel;
import blockdude.components.Tile;
import blockdude.components.PlayerTile;
import blockdude.views.GameMenu;

public class LevelView extends StackPane {

	private LevelModel levelModel;
	private ScrollPane levelScroll;
	private Pane canvas;
	private BooleanProperty levelOver;

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

		this.levelOver = new SimpleBooleanProperty(false);
		levelOver.bind(lm.getHasWonProperty());

		this.levelScroll.addEventFilter(MouseEvent.MOUSE_PRESSED, (e) -> {
			e.consume();
		});

		this.levelScroll.addEventFilter(ScrollEvent.ANY, (e) -> {
			e.consume();
		});

		lm.addTileChangeListener( (e) -> {
			render();
			if(this.levelOver.get() == true) {
				((Pane) this.getParent()).getChildren().removeAll(this);
			}
		});

		render();
	}


	public void render() {
		double canvasHeight = this.levelModel.getHeight()*Tile.TILE_SIZE;
		double canvasWidth = this.levelModel.getWidth()*Tile.TILE_SIZE;
		this.canvas.setPrefSize(canvasWidth, canvasHeight);

		List<Node> tiles = new LinkedList<Node>();

		for(int i = 0; i < this.levelModel.getHeight(); i++) {
			for(int j = 0; j < this.levelModel.getWidth(); j++) {
				if(this.levelModel.getTile(i,j) != null) {
					int x = j;
					int y = i;

					tiles.add(this.levelModel.getTile(i,j).render(x,y));

					if(this.levelModel.getTile(i,j) instanceof PlayerTile) {
						double scrollPos = (x-6)*1/(double)(this.levelModel.getWidth()-12);
						if(x>=6)
							this.levelScroll.setHvalue(scrollPos);
					}
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
