/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import jogo.Memoria;
import jogo.gerenciadores.FPS;
import jogo.gerenciadores.Teclado;

/**
 *
 * @author jhonesconrado
 */
public abstract class Motor implements WindowListener {
    
    boolean ligado;
    protected JFrame janela;
    BufferStrategy bs;
    private final int TPS;
    private final long pausaPorTick;
    private long proximoTick;
    
    BufferedImage tela;

    public Motor() {
        tela = new BufferedImage(900, 500, BufferedImage.TYPE_INT_RGB);
        
        TPS = 60;
        pausaPorTick = (long) (1e9 / TPS);
        proximoTick = System.nanoTime();
        
        janela = new JFrame("Meu jogo");
        janela.setSize(900, 500);
        janela.setLocationRelativeTo(null);
        janela.setUndecorated(true);
        janela.setIgnoreRepaint(true);
        janela.addWindowListener(this);
        ligado = true;
        janela.addKeyListener(Teclado.getInstance());
    }
    
    public void Load(){
        janela.setVisible(true);
        janela.createBufferStrategy(2);
        bs = janela.getBufferStrategy();
        onLoad();
    }
    
    public void Run(){
        while(ligado){
            if(true){
//                proximoTick += pausaPorTick;
                Update();
                Render();
                Thread.yield();
            }
        }
        Memoria.getInstance().conexão.encerrar();
        bs.dispose();
        janela.dispose();
    }
    
    public void Unload(){
        ligado = false;
    }
    
    
    private void Render(){
        
        Graphics2D g2 = tela.createGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, tela.getWidth(), tela.getHeight());
        
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        onRender(g2);
        
        g.drawImage(tela, 0, 0, getWidth(), getHeight(), null);
        
        g2.dispose();
        g.dispose();
        bs.show();
    }
    
    private void Update(){
        FPS.getInstance().Update();
        Teclado.getInstance().update();
        onUpdate();
    }
    
    public abstract void onRender(Graphics2D g);
    
    public abstract void onUpdate();
    
    public abstract void onLoad();
    
    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
    public int getWidth(){
        return janela.getWidth();
    }
    
    public int getHeight(){
        return janela.getHeight();
    }
    
}
