
package JogoTest;

import Core.Game;
import Core.KeyHearer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
/**
 *
 * @author Sameul P M
 */


public class GameTest extends Game {
    public volatile int x;
    public volatile int y;
    public volatile Point.Float v = new Point.Float();
    public volatile Point.Float p = new Point.Float();
    public KeyHearer k ;
    
    public GameTest(int w, int h) {
        super(new Dimension(w,h));
        p.x = 5;
        p.y = 300;
        v.x = 1.8f;
        v.y = 1.8f;
       k = KeyHearer.getResource();
    }

    @Override
    public void onLoad() {
        
    }

    @Override
    public void onUnload() {
        
    }

    @Override
    public void onUpdate() {
         if(k.isPressed(KeyEvent.VK_DOWN))
             p.y += v.y;
         if(k.isPressed(KeyEvent.VK_UP))
             p.y -= v.y;
         if(k.isPressed(KeyEvent.VK_RIGHT))
             p.x += v.x;
         if(k.isPressed(KeyEvent.VK_LEFT))
             p.x -= v.x;
        }   

    @Override
    public void onRender(Graphics2D g) {
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Calibre",Font.PLAIN,34));
        //g.drawString("FPS "+this.getFc().getFps(), 100, 100);
        g.fillRect((int)p.x, (int)p.y, 20, 20);
        
        
    }
}
