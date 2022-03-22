/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.entidades;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import jogo.Memoria;
import jogo.gerenciadores.Teclado;

/**
 *
 * @author jhonesconrado
 */
public class Jogador extends Entidade{

    public String nome;
    public int estado;
    
    public boolean digitando;
    
    public Jogador() {
        estado = 0;
        digitando = false;
    }

    @Override
    public void Update() {
        if(Teclado.getInstance().isRecemApertado(KeyEvent.VK_ENTER)){
            if(digitando){
                digitando = false;
                if(!Memoria.getInstance().msg.toString().equals("")){
                    Memoria.getInstance().conexão.sendMsg("msg:"+Memoria.getInstance().msg.toString());
                    Memoria.getInstance().msg = new StringBuilder();
                }
            } else {
                digitando = true;
            }
        }
        if(!digitando){
            if(Teclado.getInstance().isApertado(Teclado.getInstance().ESQUERDA)){
                Memoria.getInstance().conexão.sendMsg("a");
            }
            if(Teclado.getInstance().isApertado(Teclado.getInstance().DIREITA)){
                Memoria.getInstance().conexão.sendMsg("d");
            }
            if(Teclado.getInstance().isApertado(Teclado.getInstance().CIMA)){
                Memoria.getInstance().conexão.sendMsg("w");
            }
            if(Teclado.getInstance().isApertado(Teclado.getInstance().BAIXO)){
                Memoria.getInstance().conexão.sendMsg("s");
            }
            if(Teclado.getInstance().isRecemApertado(KeyEvent.VK_F)){
                Memoria.getInstance().conexão.sendMsg("f");
            }
            if(Teclado.getInstance().isRecemApertado(KeyEvent.VK_J)){
                Memoria.getInstance().conexão.sendMsg("matk");
            }
            if(Teclado.getInstance().isRecemApertado(KeyEvent.VK_K)){
                Memoria.getInstance().conexão.sendMsg("k");
                System.out.println("mandou k");
            }
        }
        
    }

    @Override
    public void Render(Graphics2D g) {
        g.setColor(Color.blue);
        g.fillOval(435, 235, 30, 30);
        
        if(estado == 2){
            g.setColor(Color.white);
            g.fillOval(445+Memoria.getInstance().mira.x, 245+Memoria.getInstance().mira.y, 5, 5);
        }
        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
}
