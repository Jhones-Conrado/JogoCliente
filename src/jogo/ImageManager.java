/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author jhonesconrado
 */
public class ImageManager {
    
    static private ImageManager instance;
    private HashMap<String, BufferedImage> images;
    
    private ImageManager() {
        images = new HashMap<String, BufferedImage>();
    }
    
    static public ImageManager getInstance() {
        if (instance == null) {
            instance = new ImageManager();
        }
        return instance;
    }
    
    public AnimaçãoSprite loadAnimatedSprite(String fileName, int qtdFrames) throws IOException, URISyntaxException {
        BufferedImage sheet = loadImage(fileName);
        if (sheet.getWidth() % qtdFrames != 0) {
            throw new RuntimeException("A imagem /" + fileName + " não possui " + qtdFrames + " sprites de mesmo tamanho.");
        } else {
            AnimaçãoSprite anim = new AnimaçãoSprite();
            int w = sheet.getWidth() / qtdFrames;
            int h = sheet.getHeight();
            for (int i=0; i<qtdFrames; i++)
            {
                anim.addImage(sheet.getSubimage(i*w, 0, w, h));
            }
            return anim;
        }
    }
    
    public ArrayList<BufferedImage> loadDualLayerImage(String fileName, int qtdFrames) throws IOException, URISyntaxException {
        BufferedImage sheet = loadImage(fileName);
        if (sheet.getWidth() % qtdFrames != 0) {
            throw new RuntimeException("A imagem /" + fileName + " não possui " + qtdFrames + " sprites de mesmo tamanho.");
        } else {
            ArrayList<BufferedImage> imagens = new ArrayList<>();
            int w = sheet.getWidth() / qtdFrames;
            int h = sheet.getHeight();
            for (int i=0; i<qtdFrames; i++)
            {
                imagens.add((sheet.getSubimage(i*w, 0, w, h)));
            }
            return imagens;
        }
    }

    public BufferedImage loadImage(String fileName) throws IOException, URISyntaxException {
        
        InputStream sys = ClassLoader.getSystemResourceAsStream(fileName);      
        
        if (sys == null) {
            throw new RuntimeException("A imagem /" + fileName+ " não foi encontrada.");
        } else {
            String path = fileName;
            if (images.containsKey(path)) {
                return images.get(path);
            } else {
                BufferedImage img = ImageIO.read(sys);
                images.put(path, img);
                return img;
            }
        }
    }
    
    public BufferedImage loadImage(String fileName, int x, int y, int w, int h) throws IOException, URISyntaxException {
        BufferedImage sheet = loadImage(fileName);
        BufferedImage img = sheet.getSubimage(x, y, w, h);
        return img;
    }
}