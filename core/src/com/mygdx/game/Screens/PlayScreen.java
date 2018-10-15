package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import org.lwjgl.Sys;

public class PlayScreen implements Screen {

    float i =0;
    private ScreenLoader screenLoader;

    public PlayScreen(ScreenLoader screenLoader) {
        this.screenLoader = screenLoader;



        myinfo();
    }

    private void myinfo() {
        System.out.println("PlayScreen Created");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0,1,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //batch.setProjectionMatrix(screenLoader.camera.getCamera().combined);

        i+=delta;
        if (i>2){
            System.out.println("render playscreen");
            i=0f;
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
