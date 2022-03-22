/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interpretadores;

import jogo.Cliente;

/**
 *
 * @author jhones
 */
public class SetMapa extends InterpretadorPadrao{

    public SetMapa() {
        super("mp:");
    }
    
    @Override
    void onInterpreta(String msg) {
        Cliente.mapa = Integer.valueOf(msg);
    }
    
}
