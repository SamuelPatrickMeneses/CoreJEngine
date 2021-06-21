
package Core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Sameul P M
 */
public abstract class Game extends JPanel  {
  private volatile static boolean run;
  private volatile static boolean pausa;
  private Looping render;
  private Looping updater;
  private BufferedImage backbuffer;
  
    public Game(Dimension d) {
        setSize(d);
        backbuffer = new BufferedImage((int) d.getWidth(), (int) d.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Game.run = false;
        setFocusable(true);
        requestFocus();
        addKeyListener(KeyHearer.getResource());
        render = new Looping(60,Looping.TYPE_FPS);
        updater = new Looping(100,Looping.TYPE_TPS);
    }

    private void load() {
        this.onLoad();
    }
    private void unload() {
        this.onUnload();

    }

    public void render() {
        Graphics2D g = (Graphics2D) backbuffer.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        this.onRender(g);
        g.dispose();
        g = (Graphics2D) getGraphics();
        g.drawImage(backbuffer, 0, 0,null);
        g.dispose();
    }

    public void update() {
        this.onUpdate();
    }


  public static void terminate(){
      Game.run = false;
  }
  public static void pausa(){
      Game.pausa = true;
  }
  public static void desPausa(){
      Game.pausa = false;
  }
  public  void start(){
      run = true;
      updater.start();
      render.start();
  }
  public abstract void onLoad();
  public abstract void onUnload();
  public abstract void onUpdate();
  public abstract void onRender(Graphics2D g);
  
    public class Looping extends Thread{
        private FrameCounter c;
        public static final int TYPE_FPS = 0;
        public static final int TYPE_TPS = 1;
        private Runnable r;
        public Looping(int v, int type){
            this.c = new FrameCounter(v);
            switch(type){
                case 0:
                    this.setName("render");
                    r = ()->{
                        render();
                    };
                    break;
                case 1:
                    this.setName("updater");
                    r = ()->{
                        update();   
                    };
            }
        }
        @Override
        public void run(){
            load();
            c.startCount();
            while(Game.run){
                if(Game.pausa) 
                    continue;
                r.run();
                c.update();
            }
            unload();
      }
        }
    }
   

