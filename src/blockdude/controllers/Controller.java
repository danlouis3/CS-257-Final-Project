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
import javafx.scene.control.Button;

public class Controller {

	private GameModel model;
	private StackPane viewHolder;
	private LevelView levelView;

	public Controller(StackPane vh, GameModel model) {
		this.viewHolder = vh;
		this.model = model;
	}

	public void bind(StartMenu menu) {
		menu.setStartButtonAction( (e) -> {
			this.model.load(); 
	        this.levelView = new LevelView(model.getCurrLevel());
	        this.viewHolder.getChildren().addAll(levelView);
	        this.levelView.requestFocus();
	        bind(this.levelView);
		});
			
		menu.setCodeButtonAction( (e) -> {
			System.out.println("Enter Code");
		});
	}

	public void bind(LevelView lv) {
		lv.setKeyAction( (e) -> {
			if(e.getCode() == KeyCode.LEFT)
				this.model.getCurrLevel().moveLeft();
			else if(e.getCode() == KeyCode.RIGHT)
				this.model.getCurrLevel().moveRight();
		});
	}
}