package com.CoreJEngine.app.Core;
public class Vector {
    private volatile float x;
    private volatile float y;

    public Vector(float x , float y){
        this.x = x;
        this.y = y;
    }
    
    public float getX(){
        return x;
    }
    public void setX(float x){
        this.x = x;
    }
    public float getY(){
        return y;
    }

    public void setY(float y){
        this.y = y;
    }

    public static Vector sum(Vector v1, Vector v2){
        return new Vector((v1.x + v2.x), (v1.y + v2.y)); 
    }
    public static void addition(Vector v1, Vector v2){
        v1.setX(v1.getX() + v2.getX());
        v1.setY(v1.getY() + v2.getY()); 
    }
}
