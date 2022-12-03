package com.mbg.game.m_snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class Snake extends Application {



	@Override

	public void start(Stage stage) throws IOException {
		SnakeController snake = new SnakeController();
		GameScene gs = new GameScene();
		SnakeBody sn = new SnakeBody();

		snake.buildfirst(stage);

	}


	public static void main(String[] args) {
		launch();
	}
}