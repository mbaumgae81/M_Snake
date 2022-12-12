package com.mbg.game.m_snake;

import java.awt.*;

public class CollisionCheck {
	private Rectangle[][] SnakeListe;

	public boolean checkFood(double foodX, double foodY, double snakeHeadX, double snakeHeadY) {
		boolean coll = false;
		if (foodX == snakeHeadX && foodY == snakeHeadY) coll = true;

		return coll;
	}


	public boolean collissionSnakeSelf(double[][] liste, int laenge) {
		liste = new double[laenge][laenge];
		double x = liste[0][0];
		double y = liste[0][1];
		for (int i = 1; i < laenge - 1; i++) {
			if (x == liste[i][0] && y == liste[i][1]) {
				return true;
			}
		}
		return false;
	}

	private int collossionSnakeOther() {

		return 0;
	}

}
