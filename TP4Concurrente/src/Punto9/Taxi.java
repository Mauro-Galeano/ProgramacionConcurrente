/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto9;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Taxi {
    private Semaphore semTaxi,semConcuctor,semCliente;
    
    public Taxi(){
        semTaxi= new Semaphore(1);
        semConcuctor=new Semaphore(0);
        semCliente=new Semaphore(0);
    }
    public boolean subirAlTaxi(){
        return semTaxi.tryAcquire();
    }
    public void solicitarViaje(){
        semConcuctor.release();
        try{
            semCliente.acquire();
        }catch(InterruptedException e){}
    }
    public void bajarDelTaxi(){
        semTaxi.release(); 
    }
    public void esperarCliente(){
        try{
            semConcuctor.acquire();
        }catch(InterruptedException e){}
    }
    public void terminarViaje(){
        semCliente.release();
    }
}
