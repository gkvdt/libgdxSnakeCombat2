package com.mygdx.game.Components.newSnake;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Screens.TesterScreen;

import java.util.LinkedList;

public class Snake  {

    private int stepSize,x,y,length;
    private float Fps,maxFps,fpsBuffer=0f;
    private boolean isStroke;
    private ScreenSize size;
    private int[][] pozition;
    private LinkedList<SnakeStep> nextStep;
    private TesterScreen renderScreen;

    public Snake(TesterScreen renderScreen){
        this.renderScreen = renderScreen;
        init();
        define();
        initSnake();
    }

    private void init() {
        size = new ScreenSize();

    }

    private void define() {
       stepSize = size.getStepSize();
       Fps = 0.12f;
       maxFps = 0.03f;
       isStroke=false;
       pozition = new int[240][2];
       length=5;

       nextStep = new LinkedList<SnakeStep>();
       nextStep.addFirst(new SnakeStep(stepSize,0));

    }

    public int[][] getPozition() {
        return pozition;
    }

    public int getLength() {
        return length;
    }

    //    yılanın ilk pozisyonunu çizdiren fonsyon
    private void initSnake() {

        int l=length;

        for(int i =0;length>i;i++){
            pozition[i][0]=(l*stepSize)+size.getLeftButtonEnd();
            pozition[i][1]=stepSize*2;
            l--;
        }
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = 0;length>i;i++){
            shapeRenderer.rect(pozition[i][0],pozition[i][1],size.getRectSize(),size.getRectSize());
        }
        shapeRenderer.end();

    }
    public void update(float delta){

//        yılan çarparsa bu if bloğunda oyun donacak ve artık güncellemeyecek
        if (!isStroke){
//            bu if bloğunda yılanın hızı ayarlanacak
            if (Fps<fpsBuffer){
                updateSnake(delta);
                fpsBuffer=0f;
            }else {
                fpsBuffer+=delta;
            }

        }

    }

    private void updateSnake(float delta) {
        move();
        eat(delta);
//        stroke();
//        todo update fonksyonları yazılmadı

    }

    private void eat(float delta) {
        if (renderScreen.getFood().getPozition()[0]==pozition[0][0] &&
                renderScreen.getFood().getPozition()[1]==pozition[0][1]){
//            yem yenirse olaacaklar
            length++;
            renderScreen.getFood().getNewFood();
            SpeedUp(delta);
        }
    }

    private void move() {
        rotate();

        //pozisyon güncelleme
        for (int i = length; i > 0; i--) {
            pozition[i][0] = pozition[i - 1][0];
            pozition[i][1] = pozition[i - 1][1];

        }
        //yön
        pozition[0][0] += x;
        pozition[0][1] += y;

        //duvardan geçiş
        moveToWall();

    }

//    duvardan geçme fonksyonu
    private void moveToWall() {
        //sağdan geçiş
        if (pozition[0][0] > (size.getRightButtonStart() - size.getRectSize())) {
            pozition[0][0] = size.getLeftButtonEnd();
        }
        //soldan geçi
        if (pozition[0][0] < size.getLeftButtonEnd()) {
            pozition[0][0] = size.getRightButtonStart()-size.getRectSize()-size.getSpace();
        }
        //alttan geçiş
        if (pozition[0][1] < 0) {
            pozition[0][1] = size.getWIDTH()-size.getRectSize()-size.getSpace();
        }
        //üstten geçiş
        if (pozition[0][1] > (size.getWIDTH() - size.getRectSize())) {
            pozition[0][1] = 0;
        }
    }


//    dokunuşları alıyor
    private void rotate() {
        x=nextStep.getFirst().getX();
        y=nextStep.getFirst().getY();
        if(nextStep.size()!=1){
            nextStep.removeFirst();
        }
    }

    public ScreenSize getSize() {
        return size;
    }

    public SnakeStep getNextStep() {
        return nextStep.getFirst();
    }

//    todo zamanla hız artması
    private void SpeedUp(float delta){
        if (Fps>maxFps)
        Fps-=delta/3;
    }

//    rotayı linkedliste atan fonksyon
    public void CreateRota(int x,int y){
        int xBuf = stepSize*x;
        int yBuf = stepSize*y;

        if (nextStep.size()<3) {
            nextStep.addLast(new SnakeStep(xBuf, yBuf));
        }
    }
}
