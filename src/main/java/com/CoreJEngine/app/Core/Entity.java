package com.CoreJEngine.app.Core;
import java.awt.Graphics;
public interface Entity{
	public void load();
	public void create();
	public void update();
	public void render(Graphics g);
	public void render(Graphics g, float x, float y);
	public void unload();
	public float getX();
    	public float getY();
	public void setX(float x);
	public void setY(float y);
	public float getWidth();
	public float getHeight();
	public boolean isVisible();
	public boolean isPhysical();
	public void setVisible(boolean visible);
	public void setPhysical(boolean physical);
}
