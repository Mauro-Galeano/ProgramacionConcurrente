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
public class Extractor implements Runnable{
    private Buffer buffer;
    
    public Extractor(Buffer b){
        buffer=b;
    }
    public void run(){
        while(true){
            try{
                buffer.extraer();
            }catch(InterruptedException e){}
        }
    }
}
