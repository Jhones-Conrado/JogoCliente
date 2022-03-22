/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.entidades;

import java.awt.Color;
import java.awt.Graphics2D;
import jogo.Memoria;

/**
 *
 * @author jhones
 */
public class Teleporte extends Entidade {

    @Override
    public void Update() {
    }

    @Override
    public void Render(Graphics2D g) {
        int xx = 435-Memoria.getInstance().jogador.x+x;
        int yy = 235-Memoria.getInstance().jogador.y+y;
        g.setColor(Color.white);
        g.fillOval(xx, yy, 30, 30);
    }
    
}
