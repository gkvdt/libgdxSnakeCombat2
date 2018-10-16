package com.mygdx.game.Components.Snake;

import com.badlogic.gdx.graphics.Texture;

public class FastTexture  {
    private Texture texture;
    private int x,y

    public FastTexture(String texPath,int x, int y){
        texture = new Texture(texPath);
        this.x = x;
        this.y = y;

    }
}
