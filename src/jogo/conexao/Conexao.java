/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.conexao;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonesconrado
 */
public class Conexao {
    
    private final Socket socket;
    private final PrintWriter escritor;
    
    public Conexao() throws IOException {
        socket = new Socket("localhost", 15200);
        escritor = new PrintWriter(socket.getOutputStream());
        new Thread(new Ouvidor(socket)).start();
    }
    
    public void sendMsg(String msg){
        escritor.println(msg);
        escritor.flush();
    }
    
    public void encerrar(){
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
