package com.mygdx.game.Components.Snake;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class LeftBox extends ShapeRenderer {

    ScreenSize screenSize;
    public LeftBox(){
        screenSize = new ScreenSize();

    }
    public void leftBox(){
        setColor(Color.valueOf("#364438"));
        begin(ShapeType.Filled);
            rect(0,0,screenSize.LeftButtonEnd,screenSize.WIDTH);
        end();
    }


}
