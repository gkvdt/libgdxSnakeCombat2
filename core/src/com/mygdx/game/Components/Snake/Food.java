package com.mygdx.game.Components.Snake;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Food extends ShapeRenderer{
	
	Random random;
	public int[] pozition;
	ScreenSize screenSize;
	MySnake snake;

	public Food(MySnake snake){
		this.snake=snake;
		screenSize = snake.screenSize;
		random = new Random();
		pozition = new int[2];
		setColor(Color.ORANGE);
		pozition[0]= screenSize.LeftButtonEnd+screenSize.getStepSize();//random.nextInt(24)*screenSize.getStepSize();
		pozition[1]= screenSize.getStepSize();//random.nextInt(24)*screenSize.getStepSize();
		System.out.println("Food Created - Food X = " + pozition[0]+" Food Y = "+pozition[1]);
	}
	
	public void getNewFood(){

		pozition[0]=screenSize.LeftButtonEnd+random.nextInt(24)*screenSize.getStepSize();
		pozition[1]=random.nextInt(24)*screenSize.getStepSize();
		for(int i = 0;snake.length>i;i++){
			if(snake.pozition[i][0] == pozition[0]){
				System.out.println("çakıştı");
				getNewFood();
			}
		}
		
	}
	public void getFood(){
		
		begin(ShapeType.Filled);
			rect(pozition[0],pozition[1],screenSize.getRectSize(),screenSize.getRectSize());
		end();

	}
	
	
	

}
