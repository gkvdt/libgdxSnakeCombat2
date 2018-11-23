package com.mygdx.game.IputProcessors;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Screens.TesterScreen;

public class TestInputProcessor implements InputProcessor {


    private TesterScreen testerScreen;

    public TestInputProcessor(TesterScreen testerScreen){
        this.testerScreen = testerScreen;

    }


    @Override
    public boolean keyDown(int keycode) {
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



        if(testerScreen.getButtons().getRectLeft().contains(screenX,screenY)){
            if (getX()>0 && getY()==0) {
                testerScreen.getSnake().CreateRota(0,-1);
                return true;
            }if (getX()<0 && getY()==0) {

                testerScreen.getSnake().CreateRota(0,-1);
                return true;
            }if (getX()==0 && getY()>0) {

                testerScreen.getSnake().CreateRota(-1,0);
                return true;
            }if (getX()==0 && getY()<0) {
                testerScreen.getSnake().CreateRota(-1,0);
                return true;
            }
        }

        //ekran pause butonunu almıyor
        if(testerScreen.getButtons().getRectRight().getX()<screenX &&
                testerScreen.getSnake().getSize().getRectSize()*6<screenY){
            if (getX()>0 && getY()==0) {
                testerScreen.getSnake().CreateRota(0,1);
                return true;
            }if (getX()<0 && getY()==0) {

                testerScreen.getSnake().CreateRota(0,1);
                return true;
            }if (getX()==0 && getY()>0) {

                testerScreen.getSnake().CreateRota(1,0);
                return true;
            }if (getX()==0 && getY()<0) {
                testerScreen.getSnake().CreateRota(1,0);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX+"-"+screenY);

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


    private int getX() {
//        return testerScreen.getSnake().getNextStep().getX();
        return testerScreen.getSnake().getLastRotate().getX();
    }

    private int getY(){
//        return testerScreen.getSnake().getNextStep().getY();
        return testerScreen.getSnake().getLastRotate().getY();

    }

}
