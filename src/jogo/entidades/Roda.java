/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.entidades;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jhonesconrado
 */
public class Roda extends Entidade{

    int angulo;
    
    public Roda() {
        angulo = 0;
    }

    
    @Override
    public void Update() {
        int x = 300;
        int y = 300;
        
        this.x = (int) (Math.cos(Math.toRadians(angulo)) * 50)+x;
        this.y = (int) (Math.sin(Math.toRadians(angulo)) * 50)+y;
        
        angulo += 2;
        
    }

    @Override
    public void Render(Graphics2D g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 10, 10);
        g.drawLine(300, 300, x, y);
    }
    
}
