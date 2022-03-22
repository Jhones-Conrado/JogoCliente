/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogo.conexao.Conexao;
import jogo.entidades.Entidade;
import jogo.entidades.Jogador;

/**
 *
 * @author jhonesconrado
 */
public class Memoria {
    
    public final int JOGANDO = 0;
    public final int CONVERSANDO =1;
    public final int PULANDO = 2;
    public final int CARREGANDO = 3;
    
    public int estado = 0;
    
    public Cliente cliente;
    public Jogador jogador;
    public Conexao conexão;
    public String JogadorNome;
    public ArrayList<Entidade> entidades;
    public ArrayList<Entidade> mensagens;
    
    public StringBuilder msg = new StringBuilder();
    
    public Point mira;
    public boolean atirando;
    
    
    public int mapaid = 0;
    
    private Memoria() {
        entidades = new ArrayList<>();
        mensagens = new ArrayList<>();
        jogador = new Jogador();
        this.mira = new Point();
        this.atirando = false;
        this.msg = new StringBuilder();
        try {
            conexão = new Conexao();
        } catch (IOException ex) {
            Logger.getLogger(Memoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Memoria getInstance() {
        return MemoriaHolder.INSTANCE;
    }
    
    private static class MemoriaHolder {
        private static final Memoria INSTANCE = new Memoria();
    }
}
