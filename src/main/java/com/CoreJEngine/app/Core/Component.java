package com.CoreJEngine.app.Core;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Component implements Entity{
    protected volatile float x;
    protected volatile float y;
    protected volatile float width;
    protected volatile float height;
    protected Vector v;
    protected List<Vector> lv;
    protected boolean visible = false;
    protected volatile boolean physical = false;

    public Component(float x, float y, float width, float height, float vx, float vy){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.v = new Vector(0f, 0f);
        lv =  new ArrayList<>(); 
        lv.add(new Vector(vx,vy));
    }
    public Component(float x, float y, float width, float height){
        this(x, y, width, height, 0f, 0f);
    }
    @Override
    public void load(){

    }
    @Override
    public void create(){
        setPhysical(true);
        setVisible(true);
    }
    @Override
    public void update(){
        if(physical){
            v.setY(0f);
            v.setX(0f);
            for(Vector v : lv)
                Vector.addition(this.v, v);
            this.x += v.getX();
            this.y += v.getY();
        }
    }
    @Override
    public void render(Graphics g){

    }
    @Override
    public void unload(){

    }
    @Override
    public void render(Graphics g, float x, float y){
    
    }
    @Override
    public float getX(){
        return this.x;
    }
    @Override
    public float getY(){
        return this.y;
    }
    @Override
    public void setX(float x){
        this.x = x;
    }
    @Override
    public void setY(float y){
        this.y = y;
    }
    @Override
    public float getWidth(){
        return width;
    }
    @Override
    public float getHeight(){
        return height;
    }
    @Override
    public boolean isVisible(){
        return visible;
    }
    @Override
    public boolean isPhysical(){
        return physical;
    }
    @Override
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    @Override
    public void setPhysical(boolean physical){
        this.physical = physical;
    
    }
}
    

