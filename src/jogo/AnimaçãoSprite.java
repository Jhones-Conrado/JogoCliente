/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author jhonesconrado
 */
public class AnimaçãoSprite {
    private int currentImageIndex;
    private int indexInc;
    private boolean loop;
    private final ArrayList<BufferedImage> images;
    long currentTick;
    int speed;
    
    public AnimaçãoSprite(){
        currentImageIndex = 0;
        loop = false;
        indexInc = 1;
        images = new ArrayList<>();
        currentTick = 0;
        speed = 3;
    }
    public void setLoop(boolean value){
        loop = value;
    }
    
    public boolean isLoop(){
        return loop;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void addImage(BufferedImage img){
        images.add(img);
    }
    
    public void update(){
        if (currentTick % speed == 0){
            currentImageIndex += indexInc;
            if (currentImageIndex == images.size() || currentImageIndex == -1){
                if (loop){
                    indexInc *= -1;
                    currentImageIndex += indexInc;
                } else {
                    currentImageIndex = 0;
                }
            }
        }
        currentTick++;
    }

    public int getSpritesSize(){
        return images.size();
    }
    
    public BufferedImage getImage(){
//        if(images.size() == 1){
//            return images.get(0);
//        } else {
            BufferedImage get = images.get(currentImageIndex);
            update();
            return get;
//        }
    }
    
    public BufferedImage getImageByIndex(int index){
        if(images.size() >= index){
            return images.get(index);
        } return null;
    }
}