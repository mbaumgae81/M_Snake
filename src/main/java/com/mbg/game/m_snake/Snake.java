package com.mbg.game.m_snake;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class Snake extends Application {

	public SnakeController snake;
	public SnakeBody sn;



	@Override

	public void start(Stage stage) throws IOException {
			System.out.println("---Start---");
//		 		snake = new SnakeController();
//				sn = new SnakeBody();
				///snake.sb = sn;
				//Group root = new Group();
			//Scene scene = new Scene(root, pixelx, pixely, Color.WHITE);
			//main snake = new main();
			FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("Snake_hauptmenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load());

			stage.setScene(scene);
			stage.show();

	}



//	public void playSingle(event){
//
//		Button button = (Button) event.getSource();
//		Stage stage = (Stage) button.getScene().getWindow();
//		System.out.println("Button Clicked");
//		FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("game_single.fxml"));
//		//this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		Scene scene = new Scene(fxmlLoader.load());
//		stage.setScene(scene);
//		stage.show();
//		ActionEvent e =new ActionEvent();
//
//
//
//	}



	public static void main(String[] args) {
		launch();
	}
}