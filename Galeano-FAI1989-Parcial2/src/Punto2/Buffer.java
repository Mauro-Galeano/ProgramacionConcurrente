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
    
    public void encontrarHidrogeno()throws InterruptedException{
        hidrogenos.acquire(2);
        System.out.println("Soy "+Thread.currentThread().getName()+" me junte con dos hidrogenos");
        this.hacerAgua();
    }
//    public void encontrarOxigeno()throws InterruptedException{
//        oxigenos.acquire();
//        System.out.println("Soy "+Thread.currentThread().getName()+" me junte con un oxigeno");
//    }
    public void oListo(){
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy listo para hacerme agua");
        //oxigenos.release();
    }
    public void hListo(){
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy listo para hacerme agua");
        hidrogenos.release();
    }
    private void hacerAgua(){
        System.out.println("Soy "+Thread.currentThread().getName()+" me hice agua");
        try{
            this.cargarRecipiente();
        }catch(InterruptedException e){}
    }
    private void cargarRecipiente()throws InterruptedException{
        mutex.acquire();
        if(capacidadActual>capacidad){
            System.out.println("Deben cambiar el recipiente, esta lleno");
            capacidadActual=0;
            Thread.sleep((int)Math.random()*capacidadActual);//simulo el cambio de recipiente
            System.out.println("El recipiente se cambio");
        }else{
            capacidadActual=capacidadActual+1;
        }
        mutex.release();
    }
}
