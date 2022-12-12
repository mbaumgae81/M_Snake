module com.mbg.game.m_snake {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;


	opens com.mbg.game.m_snake to javafx.fxml;
	exports com.mbg.game.m_snake;
}