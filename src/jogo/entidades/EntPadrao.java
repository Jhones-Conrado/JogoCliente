/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.entidades;

import java.awt.Color;
import java.awt.Graphics2D;
import jogo.Memoria;

/**
 *
 * @author jhonesconrado
 */
public class EntPadrao extends Entidade{
    
    private String tipo;
    public String nome;
    
    @Override
    public void Update() {
    }

    @Override
    public void Render(Graphics2D g) {
        int xx = 435-Memoria.getInstance().jogador.x+x;
        int yy = 235-Memoria.getInstance().jogador.y+y;
        g.setColor(Color.red);
        g.fillOval(xx, yy, 30, 30);
        g.setColor(Color.blue);
        g.drawString(nome, xx, yy-5);
    }
    
}
