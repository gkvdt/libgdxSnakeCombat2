package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Components.Camera;
import com.mygdx.game.Components.MyTextures;
import com.mygdx.game.Components.Sizes;
import com.mygdx.game.IputProcessors.MenuInputProcessor;


public class MenuScreen implements Screen {
    private ScreenLoader screenLoader;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Texture texture;
    private int xPoz,yPoz;
    public Rectangle rect;
    private Camera camera;
    private Sizes size;

    private MyTextures[] tx;

    float i = 0;

    public MenuScreen(ScreenLoader screenLoader){


        //init constructors
        init(screenLoader);



        //mylogs();

    }

    private void init(ScreenLoader screenLoader) {
        this.screenLoader = screenLoader;
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new Camera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        size = new Sizes(camera.getWidth(),camera.getHeight());
        initTexture();
        Gdx.input.setInputProcessor(new MenuInputProcessor(this));
        //xPoz=(Gdx.graphics.getWidth()/2)-(texture.getWidth()/2);
        yPoz = 100;



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl20.glClearColor(1,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(screenLoader.camera.getCamera().combined);

        tx[0].render(batch);
        tx[1].render(batch);
        tx[2].render(batch);
        tx[3].render(batch);

        testRender(delta);
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
        for(MyTextures t : tx){
            t.textureDispose();
        }

    }


    private void initTexture(){
        tx = new MyTextures[4];
        int x = size.getdHeight()/(tx.length+2);
        tx[0] = new MyTextures(size,"play.png",(float)x*1);
        tx[1] = new MyTextures(size,"setting.png",(float)x*2);
        tx[2] = new MyTextures(size,"score.png",(float)x*3);
        tx[3] = new MyTextures(size,"exit.png",(float)x*4);
    }

    public MyTextures[] getTx() {
        return tx;
    }

    private void mylogs(){
        //System.out.println("rect w-h : " + rect.getWidth() +"-"+rect.getHeight());
        //System.out.println("texture w-h : " + texture.getWidth() + "-" +texture.getHeight());


        //System.out.println("rect x-y : " + rect.getX() +"-"+rect.getY());
        //System.out.println("texture x-y : " + texture.getWidth() + "-" +texture.getHeight());


    }

    private void testRender(float delta){
        i+=delta;
        if (i>2){
            System.out.println("render menuScreen");
            i=0f;
        }
    }
    public ScreenLoader getScreenLoader() {
        return screenLoader;
    }
}
