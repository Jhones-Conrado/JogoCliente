/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.conexao;

import Interpretadores.ListaInterpretadores;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author jhonesconrado
 */
public class Ouvidor implements Runnable{
    
    Scanner leitor;
    
    public Ouvidor(Socket socket) throws IOException {
        leitor = new Scanner(socket.getInputStream());
    }

    @Override
    public void run() {
        while(leitor.hasNextLine()){
            ListaInterpretadores.getInstance().interpretar(leitor.nextLine());
        }
    }
    
}
