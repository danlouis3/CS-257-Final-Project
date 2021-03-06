package blockdude.views;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

/**
 * The LevelView class is a view for the levels in BlockDude as well as the in game
 * menus available when playing the game.
 * @author Phineas Callahan, Daniel Hamalainen, Sam West
 */
public class LevelView extends StackPane {

	private LevelModel levelModel;
	private ScrollPane levelScroll;
	private Pane canvas;
	private BooleanProperty levelOver;
	private BooleanProperty menuVisible;
	private Button exitButton1 = new Button("Main Menu");
	private Button exitButton2 = new Button("Main Menu");
	private Button resetButton = new Button("Reset");
	private Button nextButton = new Button("Next Level");

	public LevelView(LevelModel lm) {
		this.levelModel = lm;
		this.canvas = new Pane();
		this.canvas.setStyle("-fx-background-color: #5DE8FF");

		double buttonWidth = 150;
		this.exitButton1.setMinWidth(buttonWidth);
		this.exitButton2.setMinWidth(buttonWidth);
		this.resetButton.setMinWidth(buttonWidth);
		this.nextButton.setMinWidth(buttonWidth);

		this.levelScroll = new ScrollPane();
		this.levelScroll.setPrefViewportWidth(Tile.TILE_SIZE*12);
		this.levelScroll.setPrefViewportHeight(Tile.TILE_SIZE*8);
		this.levelScroll.setContent(this.canvas);
		this.levelScroll.setPannable(false);
		this.levelScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		this.levelScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		this.levelOver = new SimpleBooleanProperty(false);
		levelOver.bind(lm.getHasWonProperty());

		this.menuVisible = new SimpleBooleanProperty(false);

		VBox menu = new VBox();
		Label levelName = new Label(lm.getName());	

		menu.getChildren().addAll(levelName, resetButton, exitButton1);
		menu.setSpacing(15);
		menu.setAlignment(Pos.CENTER);
		menu.setMaxWidth(200);
		menu.setMaxHeight(200);
		menu.getStyleClass().add("menu");
		StackPane.setAlignment(menu, Pos.CENTER);

		menu.visibleProperty().bind(this.menuVisible);
		menu.managedProperty().bind(this.menuVisible);

		Button menuButton = new Button("Menu");
		StackPane.setAlignment(menuButton, Pos.TOP_RIGHT);
		StackPane.setMargin(menuButton, new Insets(10, 10, 0, 0));
		

		VBox endMenu = new VBox();
		Label endLabel = new Label("You Won!");

		endMenu.getChildren().addAll(endLabel, nextButton, exitButton2);
		endMenu.setSpacing(15);
		endMenu.setAlignment(Pos.CENTER);
		endMenu.setMaxWidth(200);
		endMenu.setMaxHeight(200);
		endMenu.getStyleClass().add("menu");
		StackPane.setAlignment(endMenu, Pos.CENTER);

		endMenu.visibleProperty().bind(lm.getHasWonProperty());
		endMenu.managedProperty().bind(lm.getHasWonProperty());

		//Ensures that mouse events are filtered out and that menus are closed if
		//they are open.
		this.levelScroll.addEventFilter(MouseEvent.MOUSE_PRESSED, (e) -> {
			this.menuVisible.set(false);
			this.requestFocus();
			e.consume();
		});

		//Prevents the user from scrolling themselves
		this.levelScroll.addEventFilter(ScrollEvent.ANY, (e) -> {
			e.consume();
		});

		//Ensures that the view renders whenever there is a change in the level 
		//model
		lm.addTileChangeListener( (e) -> {
			render(); 
		});

		//pulls up the in game menu whenever the user clicks the menu button
		menuButton.setOnAction( e -> {
			this.menuVisible.set(true);
		});

		this.getChildren().addAll(levelScroll, endMenu, menuButton, menu);
		render();
	}

	/**
	 * The render function renders the Level on the LevelView's canvas pane.
	 * It will rescroll the view such that the PlayerTile is in focus.
	 */
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
						if(x>=6 && this.levelModel.getWidth() > 12) {
							double scrollPosX = (x-6)*1/(double)(this.levelModel.getWidth()-12);
							this.levelScroll.setHvalue(scrollPosX);
						}
						if(y>=4 && this.levelModel.getHeight() > 8) {
							double scrollPosY = (y-4)*1/(double)(this.levelModel.getHeight()-8);
							this.levelScroll.setVvalue(scrollPosY);
						}
					}
				}
				else
					tiles.add(new Rectangle(0,0));
			}
		}

		this.canvas.getChildren().setAll(tiles);
	}

	public boolean isLevelOver() {
		return this.levelOver.get();
	}

	public boolean isMenuVisible() {
		return this.menuVisible.get();
	}

	public void setKeyAction(EventHandler<KeyEvent> handler) {
		this.setOnKeyPressed(handler);
	}

	public void setResetAction(EventHandler<ActionEvent> handler) {
		this.resetButton.setOnAction(handler);
	}

	public void setExitAction(EventHandler<ActionEvent> handler) {
		this.exitButton1.setOnAction(handler);
		this.exitButton2.setOnAction(handler);
	}

	public void setNextAction(EventHandler<ActionEvent> handler) {
		this.nextButton.setOnAction(handler);
	}
}		 
