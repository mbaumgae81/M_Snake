package com.mbg.game.m_snake;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
// Haupt Logic
public class SnakeBody {
	public enum direction {
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

	public List<Rectangle> getRects() {
		return rects;
	}

	public void setRects(List<Rectangle> rects) {
		this.rects = rects;
	}

	public direction getD() {
		return d;
	}

	public void setD(direction d) {
		this.d = d;
	}

	private void SnakeBody(){
		// Set defaults
		List<Rectangle> rects = new ArrayList<Rectangle>();
		this.d = direction.RIGHT;
		this.x = 5;					// Startposition für X
		this.y = 5;					// Startposition für Y
		this.laenge = 5;			// Start länge der Schlange
		this.height = 20;
		this.width = 20;
		// ----------------------------------------------

		// Erzeuge Rects erste Initialisierung
		for ( int i = 0; i <= 5; i++){
			rects.add(new Rectangle());

		}
		for (Rectangle i : rects){
			i.setY(1);
			i.setX(rects.indexOf(i));
			i.setHeight(this.height);
			i.setWidth(this.width);
		}

		//--------------------------------------------------------
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
		this.rects.add(new Rectangle());

		for (Rectangle a : rects){
			if (rects.lastIndexOf(rects) ==rects.indexOf(a)){
				a.setX(this.x);
				a.setY(this.y);
				a.setHeight(width);
				a.setWidth(height);
			}
		}

		if (this.rects.size() >= this.laenge) {
			this.rects.remove(0);
		}

	}








	//////////////////////////





}
