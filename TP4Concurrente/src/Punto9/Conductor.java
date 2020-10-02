/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto9;

/**
 *
 * @author carme
 */
public class Conductor implements Runnable{
    private Taxi t;
    
    public Conductor(Taxi t1){
        this.t=t1;
    }
    private void conducir(){
        System.out.println("Estoy conduciendo");
        try{
            Thread.sleep((int)Math.random()*1000);
        }catch(InterruptedException e){}
    }
    
    public void run(){
        while(true){
            t.esperarCliente();
            this.conducir();
            t.terminarViaje();
        }
    }
}
