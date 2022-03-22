/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.gerenciadores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import jogo.Memoria;

/**
 *
 * @author jhonesconrado
 */
public class Teclado implements KeyListener{
    
    public static final Object trava = new Object();
    
//    TECLAS DE COMANDO
    public final int ESQUERDA;
    public final int DIREITA;
    public final int CIMA;
    public final int BAIXO;
    public final int FUNÇÃO;
    public final int BATER;
    public final int AGARRAR;
    public final int DESLIGAR;
    
    static protected int KEY_RELEASED = 0;
    static protected int KEY_JUST_PRESSED = 1;
    static protected int KEY_PRESSED = 2;
    private final HashMap<Integer, Integer> keyCache;
    private final ArrayList<Integer> pressedKeys;
    private final ArrayList<Integer> releasedKeys;
    
    private static Teclado instance;
    
    private Teclado() {
        
        ESQUERDA = KeyEvent.VK_A;
        DIREITA = KeyEvent.VK_D;
        CIMA = KeyEvent.VK_W;
        BAIXO = KeyEvent.VK_S;
        
        FUNÇÃO = KeyEvent.VK_F;
        BATER = KeyEvent.VK_SPACE;
        AGARRAR = KeyEvent.VK_J;
        
        DESLIGAR = KeyEvent.VK_ESCAPE;
        
        keyCache = new HashMap<>();
        pressedKeys = new ArrayList<>();
        releasedKeys = new ArrayList<>();
    }
    
    public static Teclado getInstance(){
        if(instance == null){
            instance = new Teclado();
        }
        return instance;
    }
    
    public boolean isApertado(int keyId){
        synchronized(trava){
            return keyCache.containsKey(keyId) && !keyCache.get(keyId).equals(KEY_RELEASED);
        }
    }
    
    public boolean isRecemApertado(int keyId){
        synchronized(trava){
            return keyCache.containsKey(keyId) && keyCache.get(keyId).equals(KEY_JUST_PRESSED);
        }
    }
    
    public boolean isReleased(int keyId){
        synchronized(trava){
            return !keyCache.containsKey(keyId) || keyCache.get(keyId).equals(KEY_RELEASED);
        }
    }
    
    public void update(){
        synchronized(trava){
            keyCache.keySet().stream().filter((keyCode) -> (isRecemApertado(keyCode))).forEachOrdered((keyCode) -> {
                keyCache.put(keyCode, KEY_PRESSED);
            });

            pressedKeys.forEach((keyCode) -> {
                if (isReleased(keyCode)){
                    keyCache.put(keyCode, KEY_JUST_PRESSED);
                } else {
                    keyCache.put(keyCode, KEY_PRESSED);
                }
            });

            releasedKeys.forEach((keyCode) -> {
                keyCache.put(keyCode, KEY_RELEASED);
            });

            pressedKeys.clear();
            releasedKeys.clear();
        }
    }
    public void keyTyped(KeyEvent e){
        
    }
    
    public void keyPressed(KeyEvent e){
        synchronized(trava){
            pressedKeys.add(e.getKeyCode());
        }
        if(Memoria.getInstance().jogador.digitando){
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                if(Memoria.getInstance().msg.length() > 0){
                    Memoria.getInstance().msg.delete(
                            Memoria.getInstance().msg.length()-1, 
                            Memoria.getInstance().msg.length());
                }
            }
            else {
                Memoria.getInstance().msg.append(e.getKeyChar());
            }
        }
        
    }
    
    public void keyReleased(KeyEvent e){
        synchronized(trava){
            releasedKeys.add(e.getKeyCode());
        }
    }

}