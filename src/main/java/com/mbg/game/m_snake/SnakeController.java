package com.mbg.game.m_snake;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.BLACK;

public class SnakeController {
	public TextField textfield;
	private  SnakeBody sn;
	private static boolean debug = true;
	private int count;
	@FXML
	private Label welcomeText;
	private AnchorPane anchorPane;
	private Group root = new Group();

	private final int pixelx = 1200;
	private final int pixely = 800;
	//SnakeBody sb;
	//private Stage stage;
	//private Scene scene;
	//private Parent root;

//	public void setSbody(SnakeBody sn){
//		this.sb = sn;
//	}
//	public static void SnakeController();


	@FXML
	public void onChangeTect(){

		String name = textfield.getText();
		System.out.println(name);
	}



	public void onSinglePlayerClick(ActionEvent event) throws IOException {
		count = 0;
		//snake = new SnakeController();
		sn = new SnakeBody(pixelx, pixely);

		System.out.println(sn.getD());
		System.out.println(sn.getX());
		System.out.println(sn.getY());


		Button button = (Button) event.getSource();																		// nehme Evet vom Listener
		Stage stage = (Stage) button.getScene().getWindow();															// Übernehme die Scene von wo der Button gedrückt wurde
		//Pane n = stage //


		Rectangle rect = new Rectangle();
		rect.setY(500);
		rect.setX(500);
		rect.setHeight(20);
		rect.setWidth(20);
		rect.fillProperty().set(BLACK);


		//anchorPane.getChildren().addAll(rect);
		root = new Group();
		root.getChildren().add(rect);
		updateRect();
//		Parent root = FXMLLoader.load(getClass().getResource("game_single.fxml"));
		Scene scene = new Scene(root,sn.getPixelX(),sn.getPixelY());
//
		//FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("game_single.fxml"));						// Lade FXML
		//Scene scene = new Scene(fxmlLoader.load());																		// Laden


		stage.setScene(scene);
		stage.show();


		AnimationTimer tn = new AnimationTimer() {																		//Animation Timer starten
			@Override
			public void handle(long l) {
				if (count > 120){
					System.out.println(" Timer ");
					sn.moveAuto();

					count =0;
				}


			count++;
			}
		};
		tn.start();

		//this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
		 //System.out.println("test");
			if(ke.getCode() == KeyCode.UP){
				sn.setDirUp();
			}
			if(ke.getCode() == KeyCode.DOWN){
				sn.setDirDown();
			}
			if(ke.getCode() == KeyCode.RIGHT){
				sn.setDirRight();

			}
			if(ke.getCode() == KeyCode.LEFT) {
				sn.setDirLeft();
			}
			if(ke.getCode() == KeyCode.SPACE){
				sn.moveAuto();
			}
			if (debug) {
				if (ke.getCode() == KeyCode.A) {
					System.out.println(sn.getD());
					System.out.println(sn.getX());
					System.out.println(sn.getY());

					for (Rectangle r : sn.getRects()){
						System.out.println(r.getX());
						System.out.println(r.getY());
						System.out.println(r.getHeight());
						System.out.println(r.getWidth());
						System.out.println(r.fillProperty().get());
						System.out.println("----");

					}
				}
			}
//
		}
		});																		//	Event Listener Key
																										// Anzeigen

	}
	public void onnextSceneClick(ActionEvent event) throws IOException {
		Button button = (Button) event.getSource();
		//Stage stage = (Stage) button.getScene().getWindow();
//		GameScene game = new GameScene();
//
//		game.gameStart((Stage) button.getScene().getWindow());
//		System.out.println("Button Clicked");
//		FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("Snake_netzwerk.fxml"));
//		//this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		Scene scene = new Scene(fxmlLoader.load());
//		stage.setScene(scene);
//		stage.show();

	}

	private void updateRect(){

		for (Rectangle r: sn.getRects()){
			root.getChildren().add(r);

		}
	}



	public void onExitClick(ActionEvent actionEvent) {
		System.exit(0);
	}

}
