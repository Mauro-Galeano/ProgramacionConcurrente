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
public class Ruedita {
    private Semaphore semR;
    public Ruedita(){
        semR=new Semaphore(1);
    }
//    public boolean entrarALaRueda(){
//        return semR.tryAcquire();
//    }
    public void subir(String n){
        try{
            semR.acquire();
            System.out.println("Estoy corriendo, soy "+n);
            Thread.sleep((int)Math.random()*1000);
            System.out.println("Termine de correr, soy "+n);
        }catch(InterruptedException e){}
        semR.release();
    }
}
