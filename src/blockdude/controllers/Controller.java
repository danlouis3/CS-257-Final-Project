package blockdude.controllers;

import blockdude.views.LevelView;
import blockdude.views.StartMenu;
import blockdude.models.LevelModel;
import blockdude.models.GameModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.beans.value.WeakChangeListener;

public class Controller {

	private GameModel model;
	private StackPane viewHolder;

	public Controller(StackPane vh, GameModel model) {
		this.viewHolder = vh;
		this.model = model;
	}

	public void bind(StartMenu menu) {
		menu.setStartButtonAction( (e) -> {
			this.model.resetIndex();
			this.model.load();
	        initLevel();
		});
			
	}

	public void bind(LevelView lv) {
		lv.setKeyAction( (e) -> {
			if(!lv.isLevelOver() && !lv.isMenuVisible()) {
				if(e.getCode() == KeyCode.LEFT) {
					this.model.getCurrLevel().moveLeft();
				}
				else if(e.getCode() == KeyCode.RIGHT) {
					this.model.getCurrLevel().moveRight();
				}
				else if(e.getCode() == KeyCode.UP) {
					this.model.getCurrLevel().moveUp();
				}
				else if(e.getCode() == KeyCode.DOWN) {
					this.model.getCurrLevel().block();
				}
			}
		});

		lv.setResetAction( e -> {
			this.model.reload();
			initLevel();
	        remove(lv);
		});

		lv.setExitAction( e -> {
			remove(lv);
		});

		lv.setNextAction( e -> {
			this.model.load();
			initLevel();
			remove(lv);
		});
	}

	//Creates a view for the current level model and adds it to the view holder
	private void initLevel() {
		LevelView lv = new LevelView(model.getCurrLevel());
		this.viewHolder.getChildren().addAll(lv);
		lv.requestFocus();
		bind(lv);
	}
	
	private void remove(LevelView lv) {
		((Pane) lv.getParent()).getChildren().removeAll(lv);
	}
}