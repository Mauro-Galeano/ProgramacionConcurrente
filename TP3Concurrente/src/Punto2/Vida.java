/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 *
 * @author carme
 */
public class Vida {
    private int vida;
    
    public Vida(){
        vida=10;
    }
    public int curar(){
        return vida=vida+3;
    }
    public int dañar(){
        return vida=vida-3;
    }
    public int getVida(){
        return vida;
    }
}
