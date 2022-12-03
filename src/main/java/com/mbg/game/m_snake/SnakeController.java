package com.mbg.game.m_snake;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SnakeController {
	@FXML
	private Label welcomeText;

	@FXML
	protected void onHelloButtonClick() {
		welcomeText.setText("Welcome to JavaFX Application!");
	}
}