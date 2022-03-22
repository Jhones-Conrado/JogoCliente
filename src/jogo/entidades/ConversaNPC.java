/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogo.Memoria;
import jogo.gerenciadores.Imagens;
import jogo.gerenciadores.Teclado;

/**
 *
 * @author jhonesconrado
 */
public class ConversaNPC {
    
    private static final Object trava = new Object();
    
    public ArrayList<String> textos;
    public int indice;
    private Font fonte;
    
    private ConversaNPC() {
        textos = new ArrayList<>();
        indice = 0;
        
        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT, ClassLoader.getSystemResourceAsStream("fontes/MorrisRomanBlackAlt.otf"));
            fonte = fonte.deriveFont(18f);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(ConversaNPC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void putMsg(String msg){
        textos.clear();
        indice = 0;
        if(msg.contains(";")){
            String[] a = msg.split(";");
            for(String b : a){
                textos.add(b);
            }
        } else {
            textos.add(msg);
        }
    }
    
    public void update(){
        if(Teclado.getInstance().isRecemApertado(KeyEvent.VK_F)){
            if(indice+1 < textos.size()){
                indice++;
            } else {
                Memoria.getInstance().estado = Memoria.getInstance().JOGANDO;
                indice = 0;
            }
        }
    }
    
    public void render(Graphics2D g){
        try {
            g.drawImage(Imagens.getInstance().loadImage("imagens/Papiro.png"), 30, 50, 380, 450, null);
            StringBuilder t = new StringBuilder();
            String aa = textos.get(indice);
            int conta = 0;
            String[] palavras = aa.split(" ");
            for(String pa : palavras){
                t.append(pa+" ");
                conta+= pa.length()+1;
                if(conta > 40){
                    t.append("\n");
                    conta = 0;
                }
            }
            g.setColor(Color.black);
            drawString(g, t.toString(), 50, 120);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(ConversaNPC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void drawString(Graphics2D g, String text, int x, int y) {
        g.setFont(fonte);
        int lineHeight = g.getFontMetrics().getHeight();
        for (String line : text.split("\n")){
            g.drawString(new String(line.getBytes(), StandardCharsets.UTF_8), x, y += lineHeight);
        }
    }
    
    public static ConversaNPC getInstance() {
        return ConversaHolder.INSTANCE;
    }
    
    private static class ConversaHolder {

        private static final ConversaNPC INSTANCE = new ConversaNPC();
    }
}
