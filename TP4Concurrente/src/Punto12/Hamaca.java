/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto12;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Hamaca {
    private Semaphore semH;
    public Hamaca(){
        semH= new Semaphore(1);
    }
//    public boolean puedoDescansar(){
//        return semH.tryAcquire();
//    }
    public void descansar(String n){
        try{
            semH.acquire();
            System.out.println("Estoy descansando, soy "+n);
            Thread.sleep((int)Math.random()*1000);
            System.out.println("Termine de descansar, soy "+n);
        }catch(InterruptedException e){}
        semH.release();
    }
}
