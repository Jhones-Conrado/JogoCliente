/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.renders;

import java.awt.Graphics2D;
import jogo.Memoria;
import jogo.entidades.ConversaNPC;
import jogo.interfaces.Render;

/**
 *
 * @author jhones
 */
public class RenderConversa implements Render{

    @Override
    public void render(Graphics2D g) {
        if(Memoria.getInstance().estado == Memoria.getInstance().CONVERSANDO){
            ConversaNPC.getInstance().render(g);
        }
    }
    
}
