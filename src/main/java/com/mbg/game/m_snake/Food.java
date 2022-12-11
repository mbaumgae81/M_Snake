package com.mbg.game.m_snake;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;
public class Food {


	private int posX;
	private double pixelPosX;
	private double pixelPosY;
	private int posY;
	private int maxX;
	private int maxY;
	private int width;
	private Rectangle apple;
	private Random r;


	  Food(){
		apple = new Rectangle();
		// Position //
		  this.r = new Random();
		  /**
		this.posX = genRandomInt(this.maxX);
		this.posY  =genRandomInt(this.maxY);
		this.apple.setX(posToPixel(this.posX));
		this.apple.setY(posToPixel(this.posY));
		   Ohne MAX wird erst nach init übergeben

		   */
		this.apple.setWidth(20);
		this.apple.setHeight(20);
		this.apple.setArcHeight(34);
		this.apple.setArcWidth(34);
		this.apple.setStrokeWidth(2);
		this.apple.setStroke(Color.GREEN);
		this.apple.setFill(Color.AQUAMARINE);
		 System.out.println(apple.getX());
		 System.out.println(apple.getY());
		 System.out.println(apple.getStyle());
//		 System.out.println(apple.getX());
//		 System.out.println(apple.getX());

	}

	public void getNewFood(){
		this.posX = genRandomInt(this.maxX);
		this.posY  =genRandomInt(this.maxY);
		this.apple.setX(posToPixel(this.posX));
		this.apple.setY(posToPixel(this.posY));
		this.pixelPosX = posToPixel(this.posX);
		this.pixelPosY = posToPixel(this.posY);
	}
	private int genRandomInt(int MaX){
		System.out.println("INIT RND "+ this.maxX);
//		r = new Random();
		int aktRandom = r.nextInt(0, this.maxX);
		System.out.println(" RND = " + aktRandom);
		return aktRandom;
	}

	private double posToPixel(int XY){
		int posXY = XY * this.width;
		return posXY;
	}

	public double getPixelPosX() {
		return pixelPosX;
	}

	public double getPixelPosY() {
		return pixelPosY;
	}

	/***
	 *
	 * Getter Setter
	 *
	 */

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public int getMaxX() {
		return this.maxX;
	}

	public int getMaxY() {
		return this.maxY;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Rectangle getApple() {
		return apple;
	}
}
