package com.mygdx.game.Components.newSnake;


public class Setting {
    
    public float maxSpeed;
    public float speed;

    public Setting(){
        setMaxSpeed(4);
    }

    public void setMaxSpeed(int maxSpeed) {
        switch (maxSpeed){
            case 1:
                this.speed=0.12f;
                this.maxSpeed=0.03f;
                break;
            case 2:
                this.maxSpeed=0.04f;
                this.speed =0.13f;
                break;
            case 3:
                this.speed=0.14f;
                this.maxSpeed=0.05f;
                break;
            case 4:
                this.speed=0.34f;
                this.maxSpeed=0.05f;
                break;
        }
                
    }

    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    public float getSpeed() {
        return this.speed;
    }
}
