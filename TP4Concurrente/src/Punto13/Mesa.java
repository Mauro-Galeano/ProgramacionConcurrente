/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto13;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Mesa {
    private Semaphore semM, semC, semMZ;
    
    public Mesa(){
        semM=new Semaphore(1);
        semC=new Semaphore(0);
        semMZ=new Semaphore(0);
    }
    
    public void solicitarAtencion() throws InterruptedException{
        System.out.println("quiero el menu");
        semMZ.release();
    }
    public boolean sentarme(){
        return semM.tryAcquire();
    }
    public void retirarmeDeLaMesa(){
        System.out.println("La comida estuvo muy rica, muchas gracias por su atencion, soy "+Thread.currentThread().getName());
        semM.release();
    }
    public void elegirComida(){
        try{
            semC.acquire();
            System.out.println(Thread.currentThread().getName()+" esta mirando el menu...");
            System.out.println(Thread.currentThread().getName()+" eligio su pedido");
        }catch(InterruptedException e){}
        semMZ.release();
    }
    public void comer()throws InterruptedException{
        semC.acquire();
        System.out.println("Estoy comiendo");
        try{
            Thread.sleep((int)Math.random()*1000);
        }catch(InterruptedException e){}
        System.out.println("Termine de comer");
        
    }
    public void mostrarMenu()throws InterruptedException{
        semMZ.acquire();
        System.out.println("Hola mi nombre es "+Thread.currentThread().getName()+" que desea comer?");
        try{
            Thread.sleep((int)Math.random()*100);
        }catch(InterruptedException e){}
        semC.release();
        semMZ.acquire();
    }
    public void entregarPedido()throws InterruptedException{
        System.out.println("Su pedido esta listo, puede servirse");
        semC.release();
    }
}
