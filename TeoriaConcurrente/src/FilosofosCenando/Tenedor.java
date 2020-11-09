/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilosofosCenando;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Tenedor {
    private Semaphore semIzq, semDer;
    public Tenedor(){
        semIzq=new Semaphore(1);
        semDer=new Semaphore(1);
    }
    public void agarrar(){
        try{
            semIzq.acquire();
        }catch(InterruptedException e){}
    }
    
    public void soltar(){
        semIzq.release();
    }
}
