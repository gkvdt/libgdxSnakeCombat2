package com.mygdx.game.Components.newSnake;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Food{

    private Random random;
    private int[] pozition;
    private ScreenSize size;
    private Snake snake;
    private int[][] snakePozition;


    public Food(Snake snake){
        this.snake=snake;
        size = snake.getSize();
        random = new Random();
        pozition = new int[2];

        pozition[0]= size.getLeftButtonEnd()+size.getStepSize();//random.nextInt(24)*screenSize.getStepSize();
        pozition[1]= size.getStepSize();//random.nextInt(24)*screenSize.getStepSize();

    }

    public void getNewFood(){
        snakePozition = snake.getPozition();
        pozition[0]=size.getLeftButtonEnd()+random.nextInt(24)*size.getStepSize();
        pozition[1]=random.nextInt(24)*size.getStepSize();
        for(int i = 0;snake.getLength()>i;i++){
            if(snakePozition[i][0] == pozition[0] && snakePozition[i][1] == pozition[1]){
                System.out.println("çakıştı");
                getNewFood();
            }
        }

    }


    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.ORANGE);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.rect(pozition[0],pozition[1],size.getRectSize(),size.getRectSize());
        shapeRenderer.end();
    }

    public int[] getPozition() {
        return pozition;
    }
}
