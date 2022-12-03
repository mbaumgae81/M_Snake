package com.mbg.game.m_snake;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;

	private int punkte;

	public List<Integer> posPlayer;


	public void Player (String name, int punkte){
		this.name = name;
		this.punkte = punkte;
		this.posPlayer = new ArrayList<Integer>();

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
}
