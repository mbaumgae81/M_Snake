package com.mbg.game.m_snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Snake extends Application {

	public SnakeController snake;
	public SnakeBody sn;



	@Override

	/**
	 *
	 * Programm Start und Laden erstes Menu
	 *
	 */

	public void start(Stage stage) throws IOException {
			System.out.println("---Start---");

			FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("Snake_hauptmenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load());

			stage.setScene(scene);
			stage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}