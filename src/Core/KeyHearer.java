package Core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 *
 * @author Sameul P M
 */
public class KeyHearer implements KeyListener{
    private HashMap<Integer,Boolean> map;
    private static KeyHearer resource;

    private KeyHearer() {
        this.map = new HashMap<Integer,Boolean>();
    }
    public static KeyHearer getResource(){
        if(resource != null)
            return resource;
        resource = new KeyHearer();
        return resource;
    }
    
    public boolean isPressed(int key){
        return map.get(key) != null;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        map.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        map.remove(e.getKeyCode());
    }
    
}
