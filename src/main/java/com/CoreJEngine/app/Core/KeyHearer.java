package com.CoreJEngine.app.Core;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.HashMap;
public class KeyHearer implements KeyListener{
	private Map<Integer, Boolean> keyboard;
	private static KeyHearer instance;
	private Map<Integer, Long> interfaceKey;
	
	public static KeyHearer getInstance(){
		if(instance == null)
			instance = new  KeyHearer();
		return instance;
	}
	
	private KeyHearer(){
		keyboard = new HashMap<>();
		interfaceKey = new HashMap<>();
	}
	
	public void update(){
		for(Integer k : keyboard.keySet())
			if(keyboard.get(k)){
				Long  v = interfaceKey.get(k);
				interfaceKey.put(k, v != null ?  ++v : 1L);
			}else
				interfaceKey.put(k, 0L);		
	}
	public long get(int k){
		Long v = interfaceKey.get(k);
		return v != null ? v : 0L;
	}
	
	public void keyPressed(KeyEvent e){
		keyboard.put(e.getKeyCode(),true);
	}
	public void keyReleased(KeyEvent e){
		keyboard.put(e.getKeyCode(),false);
	}
	public void keyTyped(KeyEvent e){
		
	}
}