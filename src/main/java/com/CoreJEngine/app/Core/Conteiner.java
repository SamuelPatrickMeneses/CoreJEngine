package com.CoreJEngine.app.Core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Conteiner extends Component{
    private List<Entity> components;
    public Conteiner(float x, float y, float width, float height, float vx, float vy) {
        super(x, y, width, height, vx, vy);
        components = new ArrayList<>();
    }
    public Conteiner(float x, float y, float width, float height){
        this(x, y, width, height, 0f, 0f);
    }
    public void addComponent(Entity e){
        components.add(e);
    }
    public void removeComponent(Entity e){
        components.remove(e);
    }
    public int numberComponents(){
        return this.components.size();
    }
    public List<Entity> getEntitys(){
        return components;
    }
    public Entity getEntity(int i){
        return components.get(i);
    }
    @Override
    public void load() {
        super.load();
    }
    @Override
    public void render(Graphics g){
        render(g, 0f, 0f);
       
    }
    
    @Override
    public void render(Graphics g, float x, float y){
        if(isVisible()){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.fillRect((int)(this.x + x) , (int)(this.y + y), (int)width, (int)height);
            for (Entity e : components) {
                e.render(g2d, getX(), getY());
            }
        }
    }
}
