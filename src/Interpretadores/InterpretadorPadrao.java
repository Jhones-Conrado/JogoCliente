/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interpretadores;

/**
 *
 * @author jhones
 */
public abstract class InterpretadorPadrao {
    
    private String chave;
    
    public InterpretadorPadrao(String chave) {
        this.chave = chave;
        ListaInterpretadores.getInstance().inters.add(this);
    }
    
    public void interpreta(String msg){
        if(msg.startsWith(chave)){
            onInterpreta(msg.substring(chave.length()));
        }
    }
    
    abstract void onInterpreta(String msg);
    
}
