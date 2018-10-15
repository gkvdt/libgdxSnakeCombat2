package com.mygdx.game.Components.Snake;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ScreenSize extends ShapeRenderer {

    public static int WIDTH;
    public static int HEIGHT;
    public static int LeftButtonStart,RigthButtonStart;
    public static int LeftButtonEnd,RigthButtonEnd;
    private static int RectSize;
    private static int StepSize;
    public static int Space;


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

    public static int getRectSize(){
        RectSize = (WIDTH/24)-((WIDTH*20)/2400);
        return RectSize;
    }
    public static int getStepSize(){
        StepSize = (WIDTH/24);
        return StepSize;
    }


}
