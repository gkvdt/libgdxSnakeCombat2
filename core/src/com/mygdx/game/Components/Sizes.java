package com.mygdx.game.Components;

import com.badlogic.gdx.graphics.Texture;

public class Sizes  {

    private int dWidth,dHeight;
    public int originW,originH;

    float texRatio=0.25f;



    public Sizes(int dWidth,int dHeight){
        this.dHeight = dHeight;
        this.dWidth = dWidth;
        originH = this.dHeight/2;
        originW = this.dWidth/2;

    }

    public int getdHeight() {
        return dHeight;
    }

    public float menuTextureScale(Texture texture){

        float texHeight = (float)texture.getHeight();
        return (dHeight/texHeight)*texRatio;
    }


    public int getSpace(int count,int texHeight){
        return (dHeight-(texHeight*count))/(3+count);
    }







}
