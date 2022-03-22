/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interpretadores;

import jogo.Memoria;
import jogo.entidades.ConversaNPC;

/**
 *
 * @author jhones
 */
public class NpcMsg extends InterpretadorPadrao{

    public NpcMsg() {
        super("npcmsg:");
    }
    
    @Override
    void onInterpreta(String msg) {
        if(Memoria.getInstance().estado != Memoria.getInstance().CONVERSANDO){
            Memoria.getInstance().estado = Memoria.getInstance().CONVERSANDO;
            ConversaNPC.getInstance().putMsg(msg);
        }
    }
    
}
