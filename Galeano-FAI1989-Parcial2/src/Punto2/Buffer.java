/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Buffer{
    private Semaphore hidrogenos;
    private Semaphore oxigenos;
    private Semaphore mutex;
    private int capacidad,capacidadActual;
    public Buffer(int c){
        hidrogenos=new Semaphore(0);
        oxigenos=new Semaphore(0);
        mutex=new Semaphore(1);
        capacidad=c;
        capacidadActual=0;
    }
    
    private void encontrarHidrogeno()throws InterruptedException{
        hidrogenos.acquire();
        //System.out.println("Soy "+Thread.currentThread().getName()+" me junte con dos hidrogenos");
        this.hacerAgua();
    }
    private void encontrarOxigeno()throws InterruptedException{
        oxigenos.acquire();
        //System.out.println("Soy "+Thread.currentThread().getName()+" me junte con un oxigeno");
    }
    public void oListo(){
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy listo");
        oxigenos.release();
    }
    public void hListo(){
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy listo");
        hidrogenos.release();
    }
    public void hacerAgua(){
        //System.out.println("Soy "+Thread.currentThread().getName()+" me hice agua");
        try{
            //this.encontrarOxigeno();
            //this.encontrarHidrogeno();
            oxigenos.acquire();
            System.out.println("Agarre un oxigeno");
            hidrogenos.acquire(2);
            System.out.println("Agarre dos hidrogenos");
            Thread.sleep(2500);
            System.out.println("Se formo un atomo de agua");
            this.cargarRecipiente();
        }catch(InterruptedException e){}
    }
    private void cargarRecipiente()throws InterruptedException{
        mutex.acquire();
        if(capacidadActual>=capacidad){
            System.out.println("Deben cambiar el recipiente, esta lleno");
            capacidadActual=0;
            Thread.sleep(3000);//simulo el cambio de recipiente
            System.out.println("El recipiente se cambio");
        }
            capacidadActual=capacidadActual+1;
            System.out.println("Se agrego el agua al recipiente, la capacidad actual es de:"+capacidadActual);
            
        
        mutex.release();
    }
}
