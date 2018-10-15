package com.mygdx.game.Components;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Camera {

    private OrthographicCamera camera;
    private Viewport viewport;
    private int width,height;

    public Camera(int width,int height){
        this.width = width;
        this.height = height;

        camera = new OrthographicCamera();
        viewport = new FitViewport(width,height,camera);
        camera.setToOrtho(false);


    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }
}
