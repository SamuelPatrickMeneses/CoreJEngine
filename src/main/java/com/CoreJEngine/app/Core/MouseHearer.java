package com.CoreJEngine.app.Core;

import java.awt.event.*;
import java.awt.geom.Point2D;


public class MouseHearer implements MouseListener, MouseMotionListener{
	private Point2D.Float backPont;
	private Point2D.Float frontPoint;
	private static MouseHearer instance;
	private boolean pres;
	private long timePres;
	private MouseHearer(){
		backPont = new  Point2D.Float(0f, 0f);
		frontPoint = new Point2D.Float(0f, 0f);
		pres = false;
		timePres = 0l;
	}
	public static MouseHearer getInstance(){
		if(instance == null)
			instance = new MouseHearer();
		return instance;
	}
	public void update(){
		frontPoint.x = backPont.x;
		frontPoint.y = backPont.y;
		timePres = pres ? timePres + 1: 0l ;
	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		backPont.x = ev.getX();
		backPont.y = ev.getY();
		
	}
	public long getLeft(){
		return timePres;
	}
	public Point2D.Float getPoint(){
		return new Point2D.Float(frontPoint.x, frontPoint.y);
	}

	@Override
	public void mouseMoved(MouseEvent ev) {
		backPont.x = ev.getX();
		backPont.y = ev.getY();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		if(ev.getButton() == 1)
			pres = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		if(ev.getButton() == 1)
			pres = false;
		
	}
	
	

}
