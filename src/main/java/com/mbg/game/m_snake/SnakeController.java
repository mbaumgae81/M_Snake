package com.mbg.game.m_snake;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class SnakeController {
	@FXML
	private Label welcomeText;
	private AnchorPane rootPanel;
	//private Stage stage;
	//private Scene scene;
	//private Parent root;



	@FXML
public void buildfirst(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("Snake_hauptmenu.fxml"));
		Scene scene = new Scene(fxmlLoader.load());

		stage.setScene(scene);
		stage.show();
	}
	public void onSinglePlayerClick(ActionEvent event) throws IOException {
		Button button = (Button) event.getSource();
		Stage stage = (Stage) button.getScene().getWindow();
		System.out.println("Button Clicked");
		FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("game_single.fxml"));
		//this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.show();

	}
	public void onnextSceneClick(ActionEvent event) throws IOException {
		Button button = (Button) event.getSource();
		//Stage stage = (Stage) button.getScene().getWindow();
		GameScene game = new GameScene();

		game.gameStart((Stage) button.getScene().getWindow());
//		System.out.println("Button Clicked");
//		FXMLLoader fxmlLoader = new FXMLLoader(Snake.class.getResource("Snake_netzwerk.fxml"));
//		//this.stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		Scene scene = new Scene(fxmlLoader.load());
//		stage.setScene(scene);
//		stage.show();

	}



	public void onExitClick(ActionEvent actionEvent) {
		System.exit(0);
	}
}
