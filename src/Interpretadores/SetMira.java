/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interpretadores;

import jogo.Memoria;

/**
 *
 * @author jhones
 */
public class SetMira extends InterpretadorPadrao{

    public SetMira() {
        super("mr:");
    }
    
    @Override
    void onInterpreta(String msg) {
        String[] s = msg.split(",");
        Memoria.getInstance().mira.x = Integer.valueOf(s[0]);
        Memoria.getInstance().mira.y = Integer.valueOf(s[1]);
    }
    
}
