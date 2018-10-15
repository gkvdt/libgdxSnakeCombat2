package com.mygdx.game.Components.newSnake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Buttons {
    private Snake snake;
    private ScreenSize size;
    private Rectangle rectLeft,rectRight;

    public Buttons(Snake snake){
        //parameter init
        this.snake = snake;



        init();
        define();
    }

    private void init() {
        size = snake.getSize();
    }

    private void define() {

        rectLeft = new Rectangle(0,0,size.getLeftButtonEnd(),size.getWIDTH());
        rectRight= new Rectangle(size.getRightButtonStart(),0,size.getLeftButtonEnd(),size.getWIDTH());
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.valueOf("#364438"));
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        renderLeftBox(shapeRenderer);
        renderRightBox(shapeRenderer);
        shapeRenderer.end();
    }
    public void update(float delta){}

    private void renderLeftBox(ShapeRenderer shapeRenderer){
        shapeRenderer.rect(rectLeft.x,rectLeft.y,rectLeft.width,rectLeft.height);

    }

    private void renderRightBox(ShapeRenderer shapeRenderer){
        shapeRenderer.rect(rectRight.x,rectRight.y,rectRight.width+200,rectRight.height);

    }

    public Rectangle getRectLeft() {
        return rectLeft;
    }

    public Rectangle getRectRight() {
        return rectRight;
    }
}
