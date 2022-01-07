/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JogoTest;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Sameul P M
 */
public class Main {
    public static void main(String[] args){
        JFrame j = new JFrame();
        j.setSize(800, 600);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null);
        GameTest g = new GameTest(800,600);
        g.setLocation(0, 0);
        j.add(g);
        j.setVisible(true);
        g.start();
    }
}
