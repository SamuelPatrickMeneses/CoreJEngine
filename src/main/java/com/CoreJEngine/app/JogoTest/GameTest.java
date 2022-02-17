
package com.CoreJEngine.app.JogoTest;

import com.CoreJEngine.app.Core.Component;
import com.CoreJEngine.app.Core.Game;
import com.CoreJEngine.app.Core.MouseHearer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class GameTest extends Game {
    public Component b;
    public Grade gr;
    public List<Bolinha> bs;
    public long lest;
    public MouseHearer m = MouseHearer.getInstance();
    public GameTest(int w, int h) {
        super(new Dimension(w,h));
        gr = new Grade(100,100, 320,320,10,10);
        b = new Component(5, 300, 40, 40, 1.8f,0){

            @Override
            public void render(Graphics g){
                g.setColor(Color.BLACK);
                g.fillRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(),(int) this.getHeight());
            }

            @Override
            public void update(){
               super.update();
               if(this.getX() > 800 || this.getX() < 0)
                   lv.get(0).setX(-1f * lv.get(0).getX());
            }
        };
        bs = new ArrayList<>();

       
    }

    @Override
    public void onLoad() {
        b.create();
        gr.load();
        gr.create();
    }

    @Override
    public void onUnload() {
        
    }

    @Override
    public void onUpdate() {
        b.update();
        gr.update();
        if(m.getLeft() < lest){
            System.out.printf("%d / %d\n", m.getLeft(), lest);
            Point2D.Float p = m.getPoint();
            Bolinha b = new Bolinha(p.x, p.y, 40, 40);
            bs.add(b);
            b.create();
            
        }
            lest = m.getLeft();
    }

    @Override
    public void onRender(Graphics2D g) {
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Calibre",Font.PLAIN,34));
        g.drawString(String.format("FPS %d/%d", this.getFps(), this.getTps()), 100, 100);
	this.b.render(g);
        gr.render(g);
        for (Bolinha bolinha : bs) {
            bolinha.render(g);
        }
        
        
    }
}
