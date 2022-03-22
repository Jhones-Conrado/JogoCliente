/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.renders;

import java.awt.Graphics2D;
import jogo.Memoria;
import jogo.entidades.Entidade;
import static jogo.gerenciadores.Teclado.trava;
import jogo.interfaces.Render;

/**
 *
 * @author jhones
 */
public class RenderMsgs implements Render{

    @Override
    public void render(Graphics2D g) {
        synchronized(trava){
            for(Entidade e : Memoria.getInstance().mensagens){
                e.Render(g);
            }
        }
    }
    
}
