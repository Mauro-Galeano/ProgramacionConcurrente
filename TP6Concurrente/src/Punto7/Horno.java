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
public class Horno implements Runnable{
    private Cinta cinta;
    
    public Horno(Cinta c){
        cinta=c;
    }
    public void run(){
        while(true){
            try{
            cinta.dejarPastelEnCinta();
            Thread.sleep(2500);
        }catch(InterruptedException e){}
        }
    }
}
