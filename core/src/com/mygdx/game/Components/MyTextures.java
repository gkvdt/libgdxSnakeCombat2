package com.mygdx.game.Components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Modals.Modal;


public class MyTextures implements Modal{


    private Texture texture;
    private Sizes size;
    private float yKor;
    private Rectangle rectangle;

    public MyTextures(Sizes size,String texPath,float yKor){
        this.texture = new Texture(texPath);
        this.size = size;
        this.yKor = yKor;
        init();

        mylog();
    }

    private void init() {

        rectangle = new Rectangle(size.originW,(int)yKor,
                texture.getWidth()*((int)size.menuTextureScale(texture)),
                texture.getHeight()*((int)size.menuTextureScale(texture)));
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(texture,size.originW-((float)rectangle.getWidth()/2f),size.getdHeight()-(yKor+rectangle.getHeight()),(float) rectangle.getWidth(),(float) rectangle.getHeight());
        //spriteBatch.draw(texture,100,100);
        spriteBatch.end();
    }


    @Override
    public void update(float delta) {

    }



    public void textureDispose(){
        texture.dispose();
    }

    public void mylog(){
        System.out.println("size.originW : "+size.originW);
        System.out.println("yKor : "+yKor);
        System.out.println("(float) rectangle.getWidth() : "+(float) rectangle.getWidth());
        System.out.println("(float) rectangle.getHeight() : "+(float) rectangle.getHeight());

        //text info
        System.out.println("texture width: "+texture.getWidth());
        System.out.println("texture height: "+texture.getHeight());

        //size ratio
        System.out.println("ratio: "+size.menuTextureScale(texture));





    }
}
