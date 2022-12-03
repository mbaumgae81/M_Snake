package com.mbg.game.m_snake;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.SubmissionPublisher;

public class GameScene {
	public int pixelx = 1200;
	public int pixely = 800;
	public int posx = 0;
	public int posy = 0;
	int x = 0;
	int y = 0;
	Stage gameStage;






	public void gameStart(Stage gameStage) throws IOException {



		System.out.println("Button Clicked");
		//FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("game_single.fxml"));

		Group root = new Group();
		Scene scene = new Scene(root, pixelx, pixely, Color.WHITE);
		Canvas canvas = new Canvas();



		for (Rectangle n : sn.getRects()) {
			root.getChildren().add(n);
		}


//		root.getChildren().add(snake);
//

		System.out.println(x +""+ y);





		new AnimationTimer(){

			@Override
			public void handle(long l) {


				sn.moveAuto();

//				snake.xProperty().set(gs.posx);
//				snake.yProperty().set(gs.posy);
			}



		}.start();


		//this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		//Scene scene = new Scene(fxmlLoader.load());
		gameStage.setScene(scene);
		gameStage.show();
scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
	@Override
	public void handle(KeyEvent ke) {
		if(ke.getCode() == KeyCode.UP){
			sn.setD(SnakeBody.direction.UP);

		}
		if(ke.getCode() == KeyCode.DOWN){
			sn.setD(SnakeBody.direction.DOWN);
		}
		if(ke.getCode() == KeyCode.RIGHT){
			sn.setD(SnakeBody.direction.RIGHT);

		}
		if(ke.getCode() == KeyCode.LEFT){
			sn.setD(SnakeBody.direction.LEFT);
		}
	}
});

	}



}
