/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CoreJEngine.app.JogoTest;
import com.CoreJEngine.app.Core.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bolinha extends Component {
    public enum Movimento{QUEDA,ESQUERDA, DIREITA, CIMA, BAICHO}
    public static enum Tipo{BRANCO, AZUL, ROXO, VERMELHO, VERDE, PRATA}
    private Color cor;
    private Movimento estado;
    private Tipo tipo;
    private Point.Float cordenada;
    private boolean select;
    private Map<Tipo,Color> cores;
    public Bolinha(float x, float y, float width, float height) {
        super(x, y, width, height);
        cores = new HashMap<>();
        cores.put(Tipo.BRANCO, Color.WHITE);
        cores.put(Tipo.AZUL, Color.BLUE);
        cores.put(Tipo.ROXO, new Color(97, 8, 153));
        cores.put(Tipo.VERMELHO, Color.RED);
        cores.put(Tipo.VERDE, Color.GREEN);
        cores.put(Tipo.PRATA, new Color(180, 177, 181));
        Random r = new Random();
        byte t = (byte) r.nextInt(6);
        switch(t){
        case 0:
            cor = cores.get(Tipo.BRANCO);
            tipo = Tipo.BRANCO;
            break;
        case 1:
            cor = cores.get(Tipo.AZUL);
            tipo = Tipo.AZUL;
            break;
        case 2:
            cor = cores.get(Tipo.ROXO);
            tipo = Tipo.ROXO;
            break;
        case 3:
            cor = cores.get(Tipo.VERMELHO);
            tipo = Tipo.VERMELHO;
            break;
        case 4:
            cor = cores.get(Tipo.VERDE);
            tipo = Tipo.VERDE;
            break;
        case 5:
            cor = cores.get(Tipo.PRATA);
            tipo = Tipo.PRATA;
            break;
        }
        select = false;
    }
    public Tipo getTipo(){
        return tipo;    
    }
    @Override
    public void update(){
        super.update();
    }
    public void select(){
        select = true;
    }
    public void unselect(){
        select = false;
    }
    @Override
    public void render(Graphics g, float xp, float yp){
        if(isVisible()){
            g.setColor(cor);
            g.fillOval((int)(x + xp) + 2, (int)(y + yp) + 2, (int)width - 8, (int)height -8);
            
        }
    }
    @Override
    public void render(Graphics g){
        this.render(g, 0f, 0f);
    }
    public void create(){
        super.create();

    }
    
}
