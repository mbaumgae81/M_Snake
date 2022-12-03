package com.mbg.game.m_snake;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class GameScene {
	//Stage stage;

	public void gameStart(Stage gameStage) throws IOException {


		System.out.println("Button Clicked");
		//FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("game_single.fxml"));

		Group root = new Group();
		Scene scene = new Scene(root, 1200, 800, Color.WHITE);
		//gameStage.setScene(scene);
		Canvas canvas = new Canvas();
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Rectangle r = new Rectangle();
		r.setX(50);
		r.setY(50);
		r.setWidth(20);
		r.setHeight(20);
		r.setArcWidth(20);
		r.setArcHeight(20);

		root.getChildren().add(r);

		new AnimationTimer(){

			@Override
			public void handle(long l) {

				r.setX(r.getX() +1);
			}
		}.start();


		//this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		//Scene scene = new Scene(fxmlLoader.load());
		gameStage.setScene(scene);
		gameStage.show();
	}
}
