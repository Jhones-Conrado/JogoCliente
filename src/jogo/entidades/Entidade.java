/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.entidades;

import java.awt.Graphics2D;

/**
 *
 * @author jhonesconrado
 */
public abstract class Entidade {
    
    public int x, y;
    public int vida;
    public int mana;

    public Entidade() {
        
        x = 0;
        y = 0;
        vida = 0;
        mana = 0;
    }
    
    public abstract void Update();
    public abstract void Render(Graphics2D g);
    
}
