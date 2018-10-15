package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Components.Camera;
import com.mygdx.game.Components.newSnake.Setting;

import java.util.Stack;

public class ScreenLoader extends Game {

    private Stack<Screen> screens;
    public Camera camera;
    private Setting setting;

    @Override
    public void create() {


        screens = new Stack<Screen>();

        addSceen(new TesterScreen(this));

        //addSceen(new MenuScreen(this));
        loadScreen();

        camera = new Camera
                (Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        //camera.getCamera().translate((Gdx.graphics.getWidth()/2),(Gdx.graphics.getHeight()/2));

    }

    public void backScreen(){
        screens.pop();
    }




    public void addSceen(Screen screen){

        screens.push(screen);

    }


    public void loadScreen(){

        this.setScreen(screens.peek());
        System.out.print("loadScreen");
    }

    public Stack<Screen> getScreens() {
        return screens;
    }
}
