package com.mbg.game.m_snake;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Food f = new Food();

		System.out.println(f.getPosX());
		System.out.println(f.getPosY());
//		System.out.println(f.getApple());
		System.out.println(f.getPosX());
		Random r = new Random();
		int aktRandom = r.nextInt(0, 100);
		System.out.println(" RND = " + aktRandom);



//		for (int a = 0; a < 100; a++) {
//			System.out.print(f.genRandomInt(5)+1);
		}

}
