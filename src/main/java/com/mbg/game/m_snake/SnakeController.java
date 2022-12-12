package com.mbg.game.m_snake;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeController {
	public TextField textfield;
	Food food;
	private  SnakeBody sn;
	private static boolean debug = true;
	private int count;
	@FXML
	private AnchorPane anchorPane;
	private Group root = new Group();
	Label punkteLabel;
	Label spielerLabel;

	private final int pixelx = 1200;
	private final int pixely = 800;
	Rectangle apple;
	CollisionCheck ch;
	HighScore punkte;


	@FXML
	public void onChangeTect(){

		String name = textfield.getText();
		System.out.println(name);
	}



	public void onSinglePlayerClick(ActionEvent event) throws IOException {
		count = 0;
		//snake = new SnakeController();
// 	Objekte Erzeugen
		sn = new SnakeBody(pixelx,pixely, Color.BLACK);
		food = new Food();
		apple = new Rectangle();
		ch = new CollisionCheck();
		punkte = new HighScore();
// ------------------------------
		food.setMaxX(sn.getMaxX());// Errechnete Maximale Felder
		food.setMaxY(sn.getMaxY());		// für X und Y
		food.setWidth(sn.getWidth()); 	// with übergabe für posToPixels

		System.out.println(food.getPosX());
		System.out.println(food.getPosY());
//		System.out.println(food.getApple().getY());
//		System.out.println(food.getApple().getWidth());
//		System.out.println(food.getApple().getHeight());
//		System.out.println(food.getApple().getStroke());
//		System.out.println(food.getApple().getArcHeight());
//		System.out.println(food.getApple().getArcWidth());

//		System.out.println(sn.getD());
//		System.out.println(sn.getX());
//		System.out.println(sn.getY());


		Button button = (Button) event.getSource();																		// nehme Evet vom Listener
		Stage stage = (Stage) button.getScene().getWindow();															// Übernehme die Scene von wo der Button gedrückt wurde
		//Pane n = stage //



// Build Scene
		root = new Group();
//		root.getChildren().add(rect);
		erzeugeFood();
		updatePosFood();
		erzeugeRect();
		erzeugePunkteAnzeige();
		System.out.println(apple.getX()+ " " + apple.getY());
		Scene scene = new Scene(root,sn.getPixelX(),sn.getPixelY());
		stage.setScene(scene);
		stage.show();
// Build done


// Automove  and Update
		AnimationTimer tn = new AnimationTimer() {																		//Animation Timer starten
			@Override
			public void handle(long l) {
				if (count > 10){
					//System.out.println(" Timer ");
					sn.moveAuto();
					updateRectDraw();
					collision();
					count =0;
				}
			count++;
			}
		};
		tn.start();

/**
 *
 * Abfrage der Tastatur eingaben
 *
 */
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


				/**
				 *
				 * Debugging Code kann mit der BOOL debug deaktiviert werden
				 */
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
				if(ke.getCode() == KeyCode.SPACE){
					sn.moveAuto();
//					updatePosFood();
				}
				if(ke.getCode() == KeyCode.X){
					for ( Rectangle r : sn.getRects()){
						System.out.println("rgetX " + r.getX());
						System.out.println("rgetY" + r.getY());
					}
				}

			}
//
		}
		});																		//	Event Listener Key
																										// Anzeigen
/**
 *
 * Abfragen Buttons und eingaben
 *
 */

	}
	public void onnextSceneClick(ActionEvent event) throws IOException {
		Button button = (Button) event.getSource();


	}


	public void onExitClick(ActionEvent actionEvent) {
		System.exit(0);
	}



	/***
	 *
	 * Alle Rectangle erzeugen und an root anhängen
	 */
	private void collision(){
		double tmp[][] = new double[100][100];
		// Collision mit FOOD
		tmp		= sn.getTempRects();
		if (ch.checkColl(apple.getX(), apple.getY(), sn.getTempRects()[0][0], sn.getTempRects()[0][1] )){	// Prüfe Schlangenkopf mit Food
			sn.addLengthSnake();		// Schlange wird verlängert
			punkte.addPoints();			// Füge Punkte dazu
			updatePunkteAnzeige();		// Punkte Anzeige Aktualisieren
			updatePosFood();			// Erzeuge food an neuer Position
		}
		//
	}
	private void erzeugeRect(){

		for (Rectangle r: sn.getRects()){		// Füge alle in SnakeBody erzeugten Rectangles an das Grafik Objekt root
			root.getChildren().add(r);

		}
	}
		private void updatePosFood(){
			food.getNewFood();
			System.out.println(food.getPixelPosX());
			System.out.println(food.getPixelPosY());
			apple.setY(food.getPixelPosY());
			apple.setX(food.getPixelPosX());
		}
		private void erzeugeFood(){
		//	food.
			//food.neuesFood();
			apple = food.getApple();
			root.getChildren().add(apple);
		}

		private void erzeugePunkteAnzeige(){
		punkteLabel = new Label();
		punkteLabel.setText("Punkte: " +punkte.getAktuellePunkte());
		root.getChildren().add(punkteLabel);
		//punkteLabel.set
		}
		private void updatePunkteAnzeige(){
			punkteLabel.setText("Punkte: " +punkte.getAktuellePunkte());
		}


	/**
	 *
	 * Alle Positionen aktualisieren
	 *
	 */

	private void updateRectDraw(){
		double tmp[][] = new double[100][100];

		tmp		= sn.getTempRects();
		int zaehl = 0;
		int zahl2 = 0;
		for ( Rectangle r : sn.getRects()){
			r.setX(sn.getTempRects()[zaehl][0]);
			r.setY(sn.getTempRects()[zaehl][1]);
			//System.out.println(sn.getTempRects()[zaehl][0]);
			zaehl += 1;
		}
	}


}
