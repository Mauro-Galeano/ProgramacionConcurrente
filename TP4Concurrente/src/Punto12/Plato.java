/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto12;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author carme
 */
public class Plato {
    private ReentrantLock lockP;
    public Plato(){
        lockP=new ReentrantLock();
    }
//    public boolean puedoComer(){
//        return semP.tryAcquire();
//    }
    public void Comer(String n){
        try{
            lockP.lock();
            System.out.println("Estoy comiendo, soy "+n);
            Thread.sleep((int)Math.random()*1000);
            System.out.println("Termine de comer, soy "+n);
        }catch(InterruptedException e){}
        lockP.unlock();
    }
}
