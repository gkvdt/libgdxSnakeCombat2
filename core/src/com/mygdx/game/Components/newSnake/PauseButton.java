package com.mygdx.game.Components.newSnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.MyTextures;
import com.mygdx.game.IputProcessors.InputPauseButton;

public class PauseButton  {

    private MyTextures texture;
    private Snake snake;


    public PauseButton(Snake snake){
        this.snake = snake;



        Gdx.input.setInputProcessor(new InputPauseButton(this));
    }


    public void render(SpriteBatch spriteBatch){
        spriteBatch.begin();

        spriteBatch.end();
    }
    public void update(){

    }
}
