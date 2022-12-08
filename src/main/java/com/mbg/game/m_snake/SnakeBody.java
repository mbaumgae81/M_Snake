package com.mbg.game.m_snake;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.BLACK;

// Haupt Logic
public class SnakeBody {

	private enum direction {
		LEFT,
		RIGHT,
		UP,
		DOWN;
	}
	public direction d;

	private List<Rectangle> rects;
	private int laenge;
	private int x;
	private int y;
	private int height;
	private int width;
	private int pixelX;
	private int pixelY;
	private int maxX;
	private int maxY;
	private final boolean debug = true;

	private boolean gameOver = false;



	/**
	 *
	 * Methoden Start
	 *
	 */

	 public SnakeBody(int pixelsX, int pixelsY){

		// Set defaults
		List<Rectangle> rects = new ArrayList<Rectangle>();
		 if (debug) System.out.println("SB INIT -- Start ");
		this.d = direction.RIGHT;
		this.x = 5;					// Startposition für X
		this.y = 5;					// Startposition für Y
		this.laenge = 5;			// Start länge der Schlange
		this.height = 20;
		this.width = 20;
		this.pixelX = pixelsX;
		this.pixelY = pixelsY;
		this.maxX = pixelsX / height;
		this.maxY = pixelsY / width;
		 this.rects = new ArrayList<Rectangle>();

		// ----------------------------------------------


		 //		 Erzeuge Rects erste Initialisierung
		for ( int i = 0; i <= 5; i++){
			Rectangle n = new Rectangle();
			n.setWidth(width);
			n.setHeight(height);
			n.setX(posToPixel(this.x + i));
			n.setY(posToPixel((this.y)));
			n.fillProperty().set(BLACK);
			this.rects.add(n);

		}

		 if (debug)  System.out.println("SB INIT -- Ende ");
		//--------------------------------------------------------
	}

	public int posToPixel(int XY){
		 int posXY = XY * this.width;
		 return posXY;
	}



	public void moveAuto(){

		switch(this.d){					// Abhängig von der richtung eins weiter
			case RIGHT: this.x+=1;
			break;
			case LEFT: this.x-=1;
			break;
			case UP: this.y-=1;
			break;
			case DOWN: this.y+=1;
		}
		System.out.println(this.x +""+ this.y);
		this.rects.add(new Rectangle());											// erzeuge neues rect

		for (Rectangle a : this.rects){												// Fülle rect mit Daten
			if (rects.lastIndexOf(rects) ==rects.indexOf(a)){
				a.setX(this.x);
				a.setY(this.y);
				a.setHeight(width);
				a.setWidth(height);
				a.fillProperty().set(BLACK);
			}
		}

		if (this.rects.size() >= this.laenge) {
			this.rects.remove(0);
		}

	}	//end Move Auto



	/***
	 * Getter und Setter
	 *
	 */


	public void setDirRight(){
		this.d = direction.RIGHT;
		System.out.println(d);
	}
	public void setDirLeft(){
		this.d = direction.LEFT;
		System.out.println(d);
	}
	public void setDirUp(){
		this.d = direction.UP;
		System.out.println(d);
	}
	public void setDirDown(){
		this.d = direction.DOWN;
		System.out.println(d);
	}
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}


//	public void setRects(List<Rectangle> rects) {
//		this.rects = rects;
//	}

	public direction getD() {
		return d;
	}

	public void setD(direction d) {
		this.d = d;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public List<Rectangle> getRects() {
		return this.rects;
	}

	public int getPixelX() {
		return this.pixelX;
	}

	public int getPixelY() {
		return this.pixelY;
	}

	/***
	 * getter Setter Ende
	 *
	 */


	//////////////////////////





} // class Close
