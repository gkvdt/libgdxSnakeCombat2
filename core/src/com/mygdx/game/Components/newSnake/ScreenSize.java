package com.mygdx.game.Components.newSnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ScreenSize extends ShapeRenderer {

    private int WIDTH;
    private int HEIGHT;
    private int LeftButtonStart,RigthButtonStart;
    private int LeftButtonEnd,RigthButtonEnd;
    private int RectSize;
    private int StepSize;
    private int Space;


    public ScreenSize(){

        HEIGHT=(Gdx.graphics.getWidth()/24)*24;
        WIDTH=(Gdx.graphics.getHeight()/24)*24;

        LeftButtonStart = 0;
        LeftButtonEnd = (HEIGHT-WIDTH)/2;

        RigthButtonStart=WIDTH+LeftButtonEnd;
        RigthButtonEnd = WIDTH;
        Space =(WIDTH*20)/2400;
        System.out.println("ScreenSize - Width = "+HEIGHT + " Height = "+WIDTH);
    }

    public int getRectSize(){
        RectSize = (WIDTH/24)-((WIDTH*20)/2400);
        return RectSize;
    }
    public int getStepSize(){
        StepSize = (WIDTH/24);
        return StepSize;
    }

    public int getLeftButtonEnd() {
        return LeftButtonEnd;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getRightButtonStart() {
        return RigthButtonStart;
    }

    public int getRigthButtonEnd() {
        return HEIGHT;
    }

    public int getSpace() {
        return Space;
    }
}
