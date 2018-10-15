package com.mygdx.game.Components.Snake;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class RightBox extends ShapeRenderer {

    ScreenSize screenSize;
    public RightBox(){
        screenSize = new ScreenSize();

    }
    public void rigthBox(){
        setColor(Color.valueOf("#364438"));
        begin(ShapeType.Filled);
            rect(screenSize.RigthButtonStart,0,screenSize.LeftButtonEnd+200,screenSize.WIDTH);
        end();
    }


}
