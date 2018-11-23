package com.mygdx.game.Components.Snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Components.newSnake.Snake;

public class FastTexture  {
    private Texture texture;
    private int x,y;
    Snake snake;
    private Rectangle rectangle;

    public FastTexture(Snake snake,String texPath,int x, int y){
        this.snake = snake;
        texture = new Texture(texPath);
        this.x = x;
        this.y = y;
        float w = (snake.getSize().getSizes().menuTextureScale(texture)/2)*texture.getWidth();
        float h = (snake.getSize().getSizes().menuTextureScale(texture)/2)*texture.getHeight();

        rectangle = new Rectangle(x,y,w,h);

    }


    public Rectangle getRectangle() {
        return rectangle;
    }

    public void render(SpriteBatch spriteBatch){
        spriteBatch.begin();
        spriteBatch.draw(texture,x,y,rectangle.width,rectangle.height);
        spriteBatch.end();
    }

}
