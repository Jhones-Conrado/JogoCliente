/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.renders;

import java.awt.Graphics2D;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogo.Cliente;
import jogo.ImageManager;
import jogo.Memoria;
import jogo.entidades.Jogador;
import jogo.interfaces.Render;

/**
 *
 * @author jhones
 */
public class RenderFundo implements Render{
    
    @Override
    public void render(Graphics2D g) {
        try {
            if(Cliente.mapa == 0){
                g.drawImage(ImageManager.getInstance().loadImage("imagens/mapa.png"), 435-Memoria.getInstance().jogador.x, 235-Memoria.getInstance().jogador.y, null);
            } else {
                g.drawImage(ImageManager.getInstance().loadImage("imagens/casa.png"), 435-Memoria.getInstance().jogador.x, 235-Memoria.getInstance().jogador.y, null);
            }
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(RenderFundo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void paint(Graphics2D g, int mapa){
        String m = "imagens/mapagigante.png";
        if(mapa > 0){
            m = "imagens/mapa"+String.valueOf(mapa)+".png";
        }
        try {
                
            Jogador j = Memoria.getInstance().jogador;
            
//            int imgw = ImageManager.getInstance().loadImage(m).getWidth();
//            int imgh = ImageManager.getInstance().loadImage(m).getHeight();
//            
//            int quax = (j.x * -1) + 435;
//            int quay = (j.y * -1) + 235;
//            int quax2 = 900;
//            int quay2 = 500;
//            
//            if(quax < 0){
//                quax = 0;
//            }
//            if(quay < 0){
//                quay = 0;
//            }
//            if(imgw - j.x < 465){
//                quax2 = 435 + imgw - j.x;
//            }
//            if(imgh - j.y < 265){
//                quay2 = 235 + imgh - j.y;
//            }
//
//            
//            int xesquerda = j.x - 435;
//            int xdireita = j.x + 465;
//            int ycima = j.y - 235;
//            int ybaixo = j.y + 265;
//            
//            if(xesquerda < 0){
//                xesquerda = 0;
//            }
//            if(xdireita > imgw){
//                xdireita = imgw;
//            }
//            if(ycima < 0){
//                ycima = 0;
//            }
//            if(ybaixo > imgh){
//                ybaixo = imgh;
//            }
//            
//            g.drawImage(ImageManager.getInstance().loadImage(m), quax, quay, quax2, quay2, xesquerda, ycima, xdireita, ybaixo, null);

            g.drawImage(ImageManager.getInstance().loadImage(m), 435-j.x, 235-j.y, null);

        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(RenderFundo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
