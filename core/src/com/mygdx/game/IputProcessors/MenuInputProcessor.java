package com.mygdx.game.IputProcessors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Components.MyTextures;
import com.mygdx.game.Screens.ExitScreen;
import com.mygdx.game.Screens.MenuScreen;
import com.mygdx.game.Screens.MyGdxGame;
import com.mygdx.game.Screens.PlayScreen;
import com.mygdx.game.Screens.ScoreScreen;
import com.mygdx.game.Screens.ScreenLoader;
import com.mygdx.game.Screens.SettingScreen;

import org.lwjgl.Sys;

public class MenuInputProcessor implements InputProcessor{

    MenuScreen menuScreen;

    MyTextures[] textures;

    public MenuInputProcessor(MenuScreen menuScreen){
        this.menuScreen= menuScreen;
        textures = menuScreen.getTx();
        System.out.print("cnsturctr");
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("key pressed");

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (textures[0].getRectangle().contains(screenX,screenY)){
            //play
            System.out.print("play");
            menuScreen.getScreenLoader().addSceen(new MyGdxGame(menuScreen.getScreenLoader()));
            menuScreen.getScreenLoader().loadScreen();

        }

        if (textures[1].getRectangle().contains(screenX,screenY)){
            //setting
            System.out.print("setting");

            menuScreen.getScreenLoader().addSceen(new SettingScreen(menuScreen.getScreenLoader()));
            menuScreen.getScreenLoader().loadScreen();

        }

        if (textures[2].getRectangle().contains(screenX,screenY)){
            //score

            System.out.print("score");

            menuScreen.getScreenLoader().addSceen(new ScoreScreen(menuScreen.getScreenLoader()));
            menuScreen.getScreenLoader().loadScreen();

        }

        if (textures[3].getRectangle().contains(screenX,screenY)){
            //exit
            Gdx.app.exit();

        }



        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
