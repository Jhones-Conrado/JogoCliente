/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.renders;

import java.awt.Color;
import java.awt.Graphics2D;
import jogo.gerenciadores.FPS;
import jogo.interfaces.Render;

/**
 *
 * @author jhones
 */
public class RenderFPS implements Render{

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.white);
        g.drawString(String.valueOf(FPS.getInstance().getFPS()), 20, 40);
    }
    
}
