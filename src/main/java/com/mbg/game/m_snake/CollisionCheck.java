package com.mbg.game.m_snake;

public class CollisionCheck {

		public boolean checkColl(double foodX, double foodY, double snakeHeadX, double snakeHeadY){
			boolean coll = false;
				if (foodX == snakeHeadX && foodY == snakeHeadY) coll = true;

			return coll;
		}

		private int collissionFood(){

			return 0;
		}

	private int collissionWall(){

		return 0;
		}

	private int collissionSnakeSelf(){

			return 0;
		}

	private int collossionSnakeOther(){

			return 0;
		}

}
