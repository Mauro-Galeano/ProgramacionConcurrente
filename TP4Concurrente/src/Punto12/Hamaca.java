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
public class Hamaca {
    private ReentrantLock lockH;
    public Hamaca(){
        lockH=new ReentrantLock();
    }
//    public boolean puedoDescansar(){
//        return semH.tryAcquire();
//    }
    public void descansar(String n){
        try{
            lockH.lock();
            System.out.println("Estoy descansando, soy "+n);
            Thread.sleep((int)Math.random()*1000);
            System.out.println("Termine de descansar, soy "+n);
        }catch(InterruptedException e){}
        lockH.unlock();
    }
}
