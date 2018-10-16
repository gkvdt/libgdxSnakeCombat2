package com.mygdx.game.Components.Snake;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import org.lwjgl.Sys;

public class MySnake extends ShapeRenderer implements InputProcessor {
	
	public static int stepSize;
	public static int x,y;

	public static int length=5;
	private float defaultFps,fps=0f;
	public boolean isStroke;



	public static int[][] pozition;
	ScreenSize screenSize ;
	public Food yem;
	public ScoreBoard scoreBoard;
	private float limitFps=0.5f;


	public MySnake(String a){
		
	}
	public MySnake(){
		isStroke=false;
		yem = new Food(this);
		screenSize = new ScreenSize();

		stepSize=screenSize.getStepSize();
		x=stepSize;

		int l=length;
		pozition=new int[240][2];
		for(int i =0;length>i;i++){
			pozition[i][0]=(l*stepSize)+screenSize.LeftButtonEnd;
			pozition[i][1]=stepSize*2;
			l--;
		}

		scoreBoard = new ScoreBoard();

		System.out.println("Left Button Width = "+screenSize.LeftButtonEnd);
		System.out.println("Right Button Start = "+screenSize.RigthButtonStart);

		System.out.println("Step Size = "+stepSize);

		
	}

	public ScoreBoard getScoreBoard() {
		//if (defaultFps>=limitFps){defaultFps -=0.05f;}

		return scoreBoard;
	}

	public void paintSnake(float delta){

		this.begin(ShapeType.Filled);
		fps+=delta;
		System.out.println(delta);
		if(defaultFps<fps){
			move();
			fps=0;
		}
		for(int i = 0;length>i;i++){
			
			this.rect(pozition[i][0],pozition[i][1],screenSize.getRectSize(),screenSize.getRectSize());
			
		}
		this.end();
	}
	
	
	//yılanın yürümesi
	public void move() {

		// çarpma kontrolü
		if(isStrike(pozition[0][0],pozition[0][1])){
			System.out.println("deathhhh");
			isStroke = true;

		}
		
		for (int i = length; i > 0; i--) {
			pozition[i][0] = pozition[i - 1][0];
			pozition[i][1] = pozition[i - 1][1];

		}
		pozition[0][0] += x;
		pozition[0][1] += y;
		
		//sağdan geçiş
		if (pozition[0][0] > (screenSize.RigthButtonStart - screenSize.getRectSize())) {
			pozition[0][0] = screenSize.LeftButtonEnd;
		}
		//soldan geçi
		 if (pozition[0][0] < screenSize.LeftButtonEnd) {
			pozition[0][0] = screenSize.RigthButtonStart-screenSize.getRectSize()-screenSize.Space;
		}
		//alttan geçiş
		if (pozition[0][1] < 0) {
			pozition[0][1] = screenSize.WIDTH-screenSize.getRectSize()-screenSize.Space;
		}
		//üstten geçiş
		if (pozition[0][1] > (screenSize.WIDTH - screenSize.getRectSize())) {
			pozition[0][1] = 0;
		}
	}
	
	public void rotation(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
			if(x>0){return;}
			x=-stepSize;
			y=0;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
			if(x<0){return;}
			x=stepSize;
			y=0;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
			if(y>0){return;}
			x=0;
			y=-stepSize;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
			if(y>0){return;}
			x=0;
			y=stepSize;
		}
		
	}


	public static void setX(int x) {

		MySnake.x = stepSize;
		MySnake.x *= x;
	}

	public static void setY(int y) {
		MySnake.y = stepSize;
		MySnake.y *= y;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
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
		if(screenSize.LeftButtonEnd>screenX){
			if (getX()>0 && getY()==0) {
				setX(0);
				setY(-1);

				return true;
			}if (getX()<0 && getY()==0) {
				setX(0);
				setY(-1);

				return true;
			}if (getX()==0 && getY()>0) {
				setX(-1);
				setY(0);

				return true;
			}if (getX()==0 && getY()<0) {
				setX(-1);
				setY(0);

				return true;
			}
		}else if (screenSize.RigthButtonStart<=screenX){
			if (getX()>0 && getY()==0) {
				setX(0);
				setY(1);

				return true;
			}if (getX()<0 && getY()==0) {
				setX(0);
				setY(1);

				return true;
			}if (getX()==0 && getY()>0) {
				setX(1);
				setY(0);

				return true;
			}if (getX()==0 && getY()<0) {
				setX(1);
				setY(0);

				return true;
			}

		}


		return false;
	}
	
	//çarpma kotrolü
	public boolean isStrike(int x,int y){
		for(int i = 1;length>i;i++){
			if(pozition[i][0]==x && pozition[i][1]==y){
				isStroke = true;
			}
			
		}
		return isStroke;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(screenSize.LeftButtonEnd>screenX){
			return true;
		}
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
