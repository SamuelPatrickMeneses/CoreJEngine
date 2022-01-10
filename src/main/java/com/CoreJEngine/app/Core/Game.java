
package com.CoreJEngine.app.Core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public abstract class Game extends JPanel  {
  private volatile static boolean run;
  private volatile static boolean pausa;
  private Looping render;
  private Looping updater;
  private BufferedImage backbuffer;
  private KeyHearer keyboard;
  
    public Game(Dimension d, int fps, int tps) {
        setSize(d);
        backbuffer = new BufferedImage((int) d.getWidth(), (int) d.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Game.run = false;
        render = new Looping(fps,Looping.TYPE_FPS);
        updater = new Looping(tps,Looping.TYPE_TPS);
        keyboard =  KeyHearer.getInstance();
        this.addKeyListener(keyboard);
    }
    public Game(Dimension d) {
      this(d, 60, 95);
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
	    load();
      updater.start();
      render.start();
  }
  public long getFps(){
        return render.getFps();
  }
  public long getTps(){
        return updater.getFps();
  }
  public abstract void onLoad();
  public abstract void onUnload();
  public abstract void onUpdate();
  public abstract void onRender(Graphics2D g);
  
    public class Looping extends Thread{
        private FrameCounter c;
        public static final byte TYPE_FPS = 0;
        public static final byte TYPE_TPS = 1;
        private Runnable r;
        public Looping(int v, byte type){
            this.c = new FrameCounter(v);
            switch(type){
                case 0:
                    this.setName("render");
                    r = () -> render();
                    break;
                case 1:
                    this.setName("updater");
                    r = () -> update();
            }
        }
        @Override
        public void run(){
            c.startCount();
            while(Game.run){
                if(Game.pausa) 
                    continue;
                r.run();
                c.update();
            }
          if(this.getName().equals("updater"))
            unload();
        }
       public long getFps(){
           return c.getFps();
       }
    }
}
   

