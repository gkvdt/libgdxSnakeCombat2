package com.mygdx.game.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.Components.Snake.Food;
import com.mygdx.game.Components.Snake.LeftBox;
import com.mygdx.game.Components.Snake.MySnake;
import com.mygdx.game.Components.Snake.RightBox;
import com.mygdx.game.Components.Snake.ScoreBoard;


public class MyGdxGame implements Screen{
	MySnake snake;
	Food food;
	LeftBox leftBox;
	RightBox rightBox;
	ScoreBoard scoreBoard;
	public static ScreenLoader screenLoader;


	public MyGdxGame(ScreenLoader screenLoader){
		
		this.screenLoader = screenLoader;
		snake = new MySnake();
		snake.setColor(Color.YELLOW);
		food = snake.yem;
		leftBox = new LeftBox();
		rightBox = new RightBox();
		scoreBoard = new ScoreBoard();
		
		System.out.println("Snake start pozition = "+ snake.pozition[0][0]+"-"+snake.pozition[0][1]);
		System.out.println("Food start pozition = "+ food.pozition[0]+"-"+food.pozition[1]);

		


	}

	@Override
	public void render(float delta) {

		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		//ekrandaki hareket butonları
		leftBox.leftBox();
		rightBox.rigthBox();
		
		//scoreboard
		scoreBoard.stage.draw();
		
		//yemek ve yılan çizdirme
		food.getFood();
		snake.paintSnake(delta);
		
		snake.rotation();
		Gdx.input.setInputProcessor(snake);
		
		//yeme kontrolü
		if(food.pozition[0] == snake.pozition[0][0] && food.pozition[1] == snake.pozition[0][1]){
			food.getNewFood();
			snake.length++;
			snake.getScoreBoard().updateScore();
			//scoreBoard.updateScore();
		
		}
		
		//oyun biterse GameOver class ı çağıralacak
		if(snake.isStroke){
			System.out.println("stoke!!");

		}


	}

	

	
	

	@Override
	public void dispose () {

		snake.dispose();
		food.dispose();
		leftBox.dispose();
		rightBox.dispose();

	}

	@Override
	public void show() {

	}


	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

}
