/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interpretadores;

import java.util.ArrayList;
import jogo.Memoria;
import jogo.entidades.EntPadrao;
import jogo.entidades.Entidade;
import jogo.entidades.Mensagem;
import jogo.entidades.Teleporte;

/**
 *
 * @author jhones
 */
public class ArEntites extends InterpretadorPadrao {

    private final String trava = "trava";
    
    public ArEntites() {
        super("cr:");
    }
    
    @Override
    void onInterpreta(String msg) {
        ArrayList<Entidade> ent = new ArrayList<>();
        ArrayList<Entidade> msgs = new ArrayList<>();
        for(String entidade : msg.split(";")){
            if(entidade.contains(",")){
                String[] split = entidade.split(",");
                if(split.length > 2){
                    if(split[2].equals("msg")){
                        if(split.length > 3){
                            Mensagem m = new Mensagem(split[3]);
                            m.x = Integer.valueOf(split[0]);
                            m.y = Integer.valueOf(split[1]);
                            msgs.add(m);
                        }
                    } else {
                        EntPadrao et = new EntPadrao();
                        et.x = Integer.valueOf(split[0]);
                        et.y = Integer.valueOf(split[1]);
                        et.nome = split[2];
                        if(et.nome.equals(Memoria.getInstance().jogador.nome)){
                            Memoria.getInstance().jogador.x = et.x;
                            Memoria.getInstance().jogador.y = et.y;
                            Memoria.getInstance().jogador.estado = Integer.valueOf(split[3]);
                        } else {
                            ent.add(et);
                        }
                    }
                } else {
                    Teleporte t = new Teleporte();
                    t.x = Integer.valueOf(split[0]);
                    t.y = Integer.valueOf(split[1]);
                    ent.add(t);
                }
            }
        }
        synchronized(trava){
            Memoria.getInstance().entidades = ent;
            Memoria.getInstance().mensagens = msgs;
        }
    }
    
}
