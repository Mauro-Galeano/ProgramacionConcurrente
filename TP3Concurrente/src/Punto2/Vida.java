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
    public synchronized int recibirCura(){
        return vida=vida+3;
    }
    public synchronized int recibirDaño(){
        return vida=vida-3;
    }
    public int getVida(){
        return vida;
    }
    public void setVida(int v){
        this.vida=v;
    }
}
