
package Core;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class WindowHearer implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Game.terminate();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        Game.pausa();
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        Game.desPausa();
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
