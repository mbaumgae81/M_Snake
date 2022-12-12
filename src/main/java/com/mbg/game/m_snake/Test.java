package com.mbg.game.m_snake;

import javax.swing.*;
import java.awt.*;

public class Test {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("test");
		mainFrame.setSize(400,400);
		mainFrame.setVisible(true);

		Button exit = new Button("Exit");
		exit.addActionListener(e -> System.exit(0));
		exit.setBounds(300,200,100,25);
		mainFrame.add(exit);
		}

	}


//		for (int a = 0; a < 100; a++) {
//			System.out.print(f.genRandomInt(5)+1);



