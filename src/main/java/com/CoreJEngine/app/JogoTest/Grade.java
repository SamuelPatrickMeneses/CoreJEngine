
package com.CoreJEngine.app.JogoTest;
import java.util.ArrayList;
import java.util.List;

import com.CoreJEngine.app.Core.Component;
import com.CoreJEngine.app.Core.Conteiner;
import com.CoreJEngine.app.Core.Entity;

public class Grade extends Conteiner{
    public enum Estatus{FREE, ONE_SELECT, MOTION}
    private Bolinha[][] grade;
    private List<Bolinha> espera;
    private Estatus estatus;
    public Grade(float x, float y, float width, float height,int colunas, int linhas) {
        super(x, y, width, height);
        grade = new Bolinha[linhas][colunas];
        espera = new ArrayList<>();
    }
    @Override
    public void load(){
        float larguraB = (width / grade[0].length);
        float alturaB = (height / grade.length);
        for(int i = 0; i < grade[0].length * grade.length; i++)
            addComponent(new Bolinha(0, 0, larguraB, alturaB));
        int op = 0;
        for(int i = 0; i < grade.length; i++){
            for(int j = 0;j < grade[i].length;j++){
                Component c  = (Component) getEntity(op++);
                grade[i][j] = (Bolinha) c;
                
                c.setX(i == 0 ? 0: i * larguraB + 1);
                c.setY(j == 0 ? 0: j * alturaB + 1);
            }
        }
    }
    @Override
    public void create(){
        super.create();
        for(Entity e: getEntitys())
            e.create();
        estatus = Estatus.FREE;
    }

    
    
    
}
