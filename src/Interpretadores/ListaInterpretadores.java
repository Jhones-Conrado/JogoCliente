/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package Interpretadores;

import java.util.ArrayList;

/**
 *
 * @author jhones
 */
public class ListaInterpretadores {
    
    public ArrayList<InterpretadorPadrao> inters;
    
    private ListaInterpretadores() {
        inters = new ArrayList<>();
    }
    
    public void interpretar(String msg){
        for(InterpretadorPadrao i : inters){
            i.interpreta(msg);
        }
    }
    
    public static ListaInterpretadores getInstance() {
        return ListaInterpretadoresHolder.INSTANCE;
    }
    
    private static class ListaInterpretadoresHolder {
        private static final ListaInterpretadores INSTANCE = new ListaInterpretadores();
    }
}
