/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1Tema1;

/**
 *
 * @author carme
 */
public class Insertor implements Runnable{
    private Buffer buffer;
    
    public Insertor(Buffer b){
        buffer=b;
    }
    public void run(){
        int r=(int)(Math.random()*10)+1;
        buffer.insetar(r);
    }
}
