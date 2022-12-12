package com.mbg.game.m_snake;

public class HighScore {
	private int aktuellePunkte;
	private String aktSpieler;
	private int[] highScore;
	private String[] highScoreName;


	/**
	 *
	 * Konstruktor
	 *
	 */
	HighScore(){
		this.aktSpieler = "nan";
		this.aktuellePunkte = 0;

	}

	/**
	 *
	 * Methoden
	 *
	 */
	public void addPoints(){

		this.aktuellePunkte += 10;
	}
	private boolean esExistierHSfile(){

		return true;
	}

	private void erzeugeHSfile(){


	}

	/**
	 *
	 * Getter Setter
	 *
	 */

	public String getAktuellePunkte() {
		String punkte = String.valueOf(this.aktuellePunkte);
		return punkte;
	}


}
