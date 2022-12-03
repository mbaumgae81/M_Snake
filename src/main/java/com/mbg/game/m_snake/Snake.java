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
		snake.buildfirst(stage);
//
//		FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("SceneTEST.fxml"));
//		//Parent root = FXMLLoader.load(getClass().getResource("SceneTEST.fxml"));
//		//fxmlLoader.load(),
//
//// Create the Button
//		//controller = loader.getController();
//		Scene scene = new Scene(fxmlLoader.load());
//
//
//		stage.setScene(scene);
//		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}