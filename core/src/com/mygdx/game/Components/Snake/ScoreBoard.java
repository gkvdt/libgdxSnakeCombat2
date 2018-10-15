package com.mygdx.game.Components.Snake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreBoard{
	
	/*
	 * 
	 * skor tahtası
	 * 
	 */
	
	Label score;
	String scoreboard;
	public Stage stage;
	ScreenSize screenSize;
	MySnake snake;
	public ScoreBoard(){
		snake = new MySnake();
		screenSize = new ScreenSize();
		stage = new Stage();
		scoreboard = "0";
		score = new Label("Score : "+scoreboard,new Label.LabelStyle(new BitmapFont(),Color.YELLOW));
		score.setPosition(screenSize.getStepSize(), screenSize.WIDTH-(2*screenSize.getStepSize()));
		stage.addActor(score);
		
	}
	
	//skor arttırma
	public void updateScore(){
		
		scoreboard = "Score : "+(snake.length-5)+"";
		score.setText(scoreboard);
	}
	
	

}
