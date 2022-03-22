/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.renders;

import java.awt.Graphics2D;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogo.gerenciadores.Imagens;
import jogo.interfaces.Render;

/**
 *
 * @author jhonesconrado
 */
public class UI implements Render{
    
    private UI() {
    }
    
    @Override
    public void render(Graphics2D g){
        try {
            g.drawImage(Imagens.getInstance().loadImage("imagens/FundoUI.png"), 0, 0, null);
            g.drawImage(Imagens.getInstance().loadImage("imagens/UIVida.png"), 403, 2, null);
            g.drawImage(Imagens.getInstance().loadImage("imagens/UIMana.png"), 450, 2, null);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static UI getInstance() {
        return UIHolder.INSTANCE;
    }
    
    private static class UIHolder {

        private static final UI INSTANCE = new UI();
    }
}
