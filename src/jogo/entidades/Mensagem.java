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
public class Mensagem extends Entidade {
    
    private String msg;

    public Mensagem(String msg) {
        this.msg = msg;
    }
    
    @Override
    public void Update() {

    }

    @Override
    public void Render(Graphics2D g) {
        g.setColor(Color.yellow);
        g.drawString(msg, 435-Memoria.getInstance().jogador.x+x, 235-Memoria.getInstance().jogador.y+y);
    }
    
}
