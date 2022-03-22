/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.renders;

import java.awt.Color;
import java.awt.Graphics2D;
import jogo.Memoria;
import jogo.interfaces.Render;

/**
 *
 * @author jhones
 */
public class RenderEscrita implements Render{

    @Override
    public void render(Graphics2D g) {
        if(Memoria.getInstance().jogador.digitando){
            g.setColor(Color.red);
            g.drawString(Memoria.getInstance().msg.toString(), 300, 100);
        }
    }
    
}
