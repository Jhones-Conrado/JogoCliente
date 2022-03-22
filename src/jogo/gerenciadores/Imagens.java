/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.gerenciadores;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author jhonesconrado
 */
public class Imagens {
    
    private HashMap<String, BufferedImage> imagens;
    
    private Imagens() {
        imagens = new HashMap<>();
    }
    
    public BufferedImage loadImage(String fileName) throws IOException, URISyntaxException {
        if(imagens.containsKey(fileName)){
            return imagens.get(fileName);
        } else {
                InputStream sys = ClassLoader.getSystemResourceAsStream(fileName);                
                BufferedImage img = ImageIO.read(sys);
                imagens.put(fileName, img);
                return img;
        }
    }
    
    public static Imagens getInstance() {
        return ImagensHolder.INSTANCE;
    }
    
    private static class ImagensHolder {

        private static final Imagens INSTANCE = new Imagens();
    }
}
