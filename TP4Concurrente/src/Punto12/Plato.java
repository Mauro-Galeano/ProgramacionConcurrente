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
public class Plato {
    private Semaphore semP;
    public Plato(){
        semP=new Semaphore(1);
    }
//    public boolean puedoComer(){
//        return semP.tryAcquire();
//    }
    public void Comer(String n){
        try{
            semP.acquire();
            System.out.println("Estoy comiendo, soy "+n);
            Thread.sleep((int)Math.random()*1000);
            System.out.println("Termine de comer, soy "+n);
        }catch(InterruptedException e){}
        semP.release();
    }
}
