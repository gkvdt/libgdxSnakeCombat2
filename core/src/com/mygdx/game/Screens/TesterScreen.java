package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Components.newSnake.Buttons;
import com.mygdx.game.Components.newSnake.Food;
import com.mygdx.game.Components.newSnake.Setting;
import com.mygdx.game.Components.newSnake.Snake;
import com.mygdx.game.IputProcessors.TestInputProcessor;

public class TesterScreen implements Screen{

    private ScreenLoader screenLoader;
    private SpriteBatch batch;
    private Snake snake;
    private ShapeRenderer shapeRenderer;
    private Buttons buttons;
    private Food food;



    BitmapFont font;

    public TesterScreen(ScreenLoader screenLoader){
        this.screenLoader = screenLoader;
        batch = new SpriteBatch();
        snake = new Snake(this);
        shapeRenderer = new ShapeRenderer();

        buttons = new Buttons(snake);
        food = new Food(snake);



        //--------------

        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        font.getData().setScale(2);
        font.setColor(Color.YELLOW);
        //--------------
        Gdx.input.setInputProcessor(new TestInputProcessor(this));

    }

    public Buttons getButtons() {
        return buttons;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(screenLoader.camera.getCamera().combined);


        buttons.render(shapeRenderer);
        buttons.update(delta);

        snake.render(shapeRenderer);
        snake.update(delta);

        food.render(shapeRenderer);


        //--------------

        batch.begin();
        String score = "Score : ";
        font.draw(batch,score+(snake.getLength()-5),snake.getSize().getRectSize(),snake.getSize().getWIDTH()-(
                snake.getSize().getRectSize()*2
                ));
        batch.end();
        //--------------


    }

    public Snake getSnake() {
        return snake;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


    public Food getFood() {
        return food;
    }

    public ScreenLoader getLoader(){
        return screenLoader;

    }


}
