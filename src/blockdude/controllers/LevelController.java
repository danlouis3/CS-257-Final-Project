package blockdude.controllers;

import blockdude.views.LevelView;
import blockdude.models.LevelModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.ScrollEvent;

public class LevelController {

	private LevelModel levelModel;
	private LevelView levelView;

	public LevelController(LevelModel lm, LevelView lv) {
		this.levelModel = lm;
		lv = lv;

		lv.getMenuButton().setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				lm.setMenuVisible(!lm.isMenuVisible());
			}
		});

		lv.getCanvas().setOnMouseClicked( (e) -> { 
			if(lm.isMenuVisible()) 
				lm.setMenuVisible(false);
		});

		lv.getScrollPane().addEventFilter(ScrollEvent.SCROLL, (e) -> {
			if(e.getDeltaX() > 0)
				System.out.println("Move left");
			else
				System.out.println("Move right");

			e.consume();
		});
		
	}
}