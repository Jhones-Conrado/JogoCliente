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
public class SetJogador extends InterpretadorPadrao{

    public SetJogador() {
        super("Jogador");
    }
    
    @Override
    void onInterpreta(String msg) {
        Memoria.getInstance().jogador.nome = "Jogador"+msg;
    }
    
}
