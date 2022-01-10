
package com.CoreJEngine.app.JogoTest;

import com.CoreJEngine.app.Core.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;


public class GameTest extends Game {
    public volatile int x;
    public volatile int y;
    public volatile Point.Float v = new Point.Float();
    public volatile Point.Float p = new Point.Float();
    
    public GameTest(int w, int h) {
        super(new Dimension(w,h));
        p.x = 5;
        p.y = 300;
        v.x = 1.8f;
       
    }

    @Override
    public void onLoad() {
        
    }

    @Override
    public void onUnload() {
        
    }

    @Override
    public void onUpdate() {
        p.x += v.x;
        if(p.x > 800 || p.x < 0){
            v.x *= -1;
        }   
    }

    @Override
    public void onRender(Graphics2D g) {
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Calibre",Font.PLAIN,34));
        g.drawString(String.format("FPS %d/%d", this.getFps(), this.getTps()), 100, 100);
        g.fillRect((int)p.x, (int)p.y, 20, 20);
        
        
    }
}
