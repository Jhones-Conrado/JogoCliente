/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Graphics2D;
import jogo.entidades.ConversaNPC;
import jogo.gerenciadores.Teclado;
import jogo.interfaces.Render;
import jogo.renders.RenderConversa;
import jogo.renders.RenderEntidades;
import jogo.renders.RenderEscrita;
import jogo.renders.RenderFPS;
import jogo.renders.RenderFundo;
import jogo.renders.RenderMsgs;
import nucleo.Motor;

/**
 *
 * @author jhonesconrado
 */
public class Cliente extends Motor {
    
    public static int mapa = 0;
    
    private final Render fundo;
    private final RenderEntidades entidades;
    private final RenderMsgs mensagens;
    private final RenderConversa conversa;
    private final RenderFPS fps;
    private final RenderEscrita escrita;
    
    
    public Cliente() {
        janela.setLayout(null);
        this.fundo = new RenderFundo();
        this.entidades = new RenderEntidades();
        this.mensagens = new RenderMsgs();
        this.conversa = new RenderConversa();
        this.fps = new RenderFPS();
        this.escrita = new RenderEscrita();
        Load();
        Run();
    }

    @Override
    public void onRender(Graphics2D g) {
        fundo.render(g);
        entidades.render(g);
        Memoria.getInstance().jogador.Render(g);
        mensagens.render(g);
        escrita.render(g);
        conversa.render(g);
        fps.render(g);
    }
    
    @Override
    public void onUpdate() {
        if(Teclado.getInstance().isApertado(Teclado.getInstance().DESLIGAR)){
            Unload();
        }
        if(Memoria.getInstance().estado == Memoria.getInstance().JOGANDO){
            Memoria.getInstance().jogador.Update();
        } else if(Memoria.getInstance().estado == Memoria.getInstance().CONVERSANDO){
            ConversaNPC.getInstance().update();
        }
    }
    
    @Override
    public void onLoad() {
    }
    
}
