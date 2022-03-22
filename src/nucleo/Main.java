/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

import Interpretadores.ArEntites;
import Interpretadores.NpcMsg;
import Interpretadores.SetJogador;
import Interpretadores.SetMapa;
import Interpretadores.SetMira;
import jogo.Cliente;
import jogo.Memoria;
import jogo.conexao.Conexao;
/**
 *
 * @author jhonesconrado
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new ArEntites();
        new NpcMsg();
        new SetJogador();
        new SetMapa();
        new SetMira();
        
        Conexao conexão = Memoria.getInstance().conexão;
        Memoria.getInstance().cliente = new Cliente();
    }
    
}
