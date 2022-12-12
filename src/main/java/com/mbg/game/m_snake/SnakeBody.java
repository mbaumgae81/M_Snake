package com.mbg.game.m_snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// Haupt Logic
public class SnakeBody {

	private enum direction {
		LEFT,
		RIGHT,
		UP,
		DOWN;
	}
	public direction d;

	private Rectangle[] rects;
	private double[][]  tempRects;
	private int laenge;
	private int x;
	private int y;
	private final int maxLength = 100;
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

	  SnakeBody(int pixelsX, int pixelsY, Color c){

		// Set defaults
		//List<Rectangle> rects = new ArrayList<Rectangle>();
		 this.rects = new Rectangle[maxLength];
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

		// ----------------------------------------------


		 //		 Erzeuge Rects erste Initialisierung
		for ( int i = 0; i < maxLength; i++){
			Rectangle n = new Rectangle();
			n.setWidth(width);
			n.setHeight(height);
			n.setStrokeWidth(2);
			n.setStroke(Color.WHITE);
			n.setY(posToPixel((this.y)));
			n.setX(posToPixel(this.x));
			n.fillProperty().set(c);

			if (i  >laenge) {
				n.setVisible(false);
			}

			this.rects[i] = n;

		}

		 if (debug)  System.out.println("SB INIT -- Ende ");
		//--------------------------------------------------------
	}
	public void addLengthSnake(){
		 this.laenge += 2;
	}
	private int posToPixel(int XY){
		 int posXY = XY * this.width;
		 return posXY;
	}

	private void updateRects(){
		this.tempRects = new double[maxLength][maxLength];			// Speicher der X/y Pixeal Pos der Rects

		for ( int r =1 ; r < 100; r++) {
			if (r  < this.laenge) {
				this.rects[r].setVisible(true);
			}
				this.tempRects[r][0] =  this.rects[r-1].getX();                        // Startet in der 2. row [0][0]
				this.tempRects[r][1] =  this.rects[r-1].getY();////// 					[0][1]
//			System.out.println("rects" + r +" getX: "+ this.rects[r].getX());
//			System.out.println("rects" + r +" getX: "+ this.rects[r].getY());
//			System.out.println("Temps POS " +r + "0 "+ this.tempRects[r][0]);
//			System.out.println("Temps POS " +r + "1 "+ this.tempRects[r][1]);

		}
		this.tempRects[0][0] = posToPixel(this.x);
		this.tempRects[0][1] = posToPixel(this.y);
//		System.out.println("rects" +" getX: "+ this.rects[0].getX());
//		System.out.println("rects" + " getX: "+ this.rects[0].getY());
//		System.out.println("Temps POS " + "0 "+ this.tempRects[0][0]);
//		System.out.println("Temps POS " + "1 "+ this.tempRects[0][1]);
		}

	public void moveAuto(){

		switch(this.d){					// Abhängig von der richtung eins weiter
			case RIGHT:  this.x+=1;
			break;
			case LEFT: this.x-=1;
			break;
			case UP: this.y-=1;
			break;
			case DOWN: this.y+=1;
			break;
		}
		if (this.x > this.maxX) this.x =0;		// Überschlag auf gegenüber liegende Seite
		if (this.x < 0) this.x = maxX;			//
		if (this.y > this.maxY) this.y =0;		//
		if (this.y < 0) this.y = maxY;			//

		updateRects();
		//System.out.println(this.x +" "+ this.y);
											// erzeuge neues rect


	}	//end Move Auto


	public double[][] getTempRects() {
		return tempRects;
	}

	public void setTempRects(double[][] tempRects) {
		this.tempRects = tempRects;
	}

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

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public direction getD() {
		return d;
	}



	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}


	public Rectangle[] getRects() {
		return rects;
	}

	public void setRects(Rectangle[] rects) {
		this.rects = rects;
	}

	public int getPixelX() {
		return this.pixelX;
	}

	public int getPixelY() {
		return this.pixelY;
	}

	public int getWidth() {
		return width;
	}

	/***
	 * getter Setter Ende
	 *
	 */


} // class Close
