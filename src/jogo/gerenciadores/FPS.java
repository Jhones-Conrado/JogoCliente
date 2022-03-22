/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.gerenciadores;

/**
 *
 * @author jhonesconrado
 */
public class FPS {
    
    long count;
    long fps;
    long nanosNoSegundo;
    long marca;
    
    private FPS() {
        fps = 0;
        count = 0l;
        nanosNoSegundo = (long) 1e9;
        marca = System.nanoTime();
    }
    
    public void Update(){
        count++;
        if(System.nanoTime() - marca > nanosNoSegundo){
            fps = count;
            count = 0;
            marca = System.nanoTime();
        }
    }
    
    public long getFPS(){
        return fps;
    }
    
    public static FPS getInstance() {
        return FPSHolder.INSTANCE;
    }
    
    private static class FPSHolder {

        private static final FPS INSTANCE = new FPS();
    }
}
