/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto7;

/**
 *
 * @author carme
 */
public class Empaquetador implements Runnable{
    private Cinta cinta;
    private int r;
    
    public Empaquetador(Cinta c){
        cinta=c;
    }
    public void run(){
        while(true){
            r=(int)(Math.random()*10)+1;
            try{
                cinta.tomarPastel();
                this.colocandoPastel();
                cinta.dejarPastel(r);
            }catch(InterruptedException e){}
        }
    }
    public void colocandoPastel(){
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}
    }
}
