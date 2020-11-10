/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Buffer {
    private int cantMaxA,cantMaxB,cantActualA,cantActualB;
    private Semaphore semA,semB;
    public Buffer(int cantMaxA,int cantMaxB){
        this.cantMaxA=cantMaxA;
        this.cantMaxB=cantMaxB;
        cantActualA=0;
        cantActualB=0;
        semA=new Semaphore(1);
        semB=new Semaphore(1);
    }
    
    public void imprimirEnA(char A)throws InterruptedException{
        cantActualA++;
        if(cantMaxA<cantActualA){
            System.out.println("Soy "+Thread.currentThread().getName()+" no puedo imprimir, estan todas las impresoras de tipo A usadas, debo esperar");
            semA.acquire();
        }
        System.out.println("Soy "+Thread.currentThread().getName()+" lo que imprimo es: "+A);
    }
    
    public void terminarDeImprimirA(){
        System.out.println("Ya termine de imprimir, soy "+Thread.currentThread().getName());
        cantActualA--;
        semA.release();
    }
    public void imprimirEnB(char B)throws InterruptedException{
        cantActualB++;
        if(cantMaxB<cantActualB){
            System.out.println("Soy "+Thread.currentThread().getName()+" no puedo imprimir, estan todas las ompresoras de tipo B usadas, debo esperar");
            semB.acquire();
        }
        System.out.println("Soy "+Thread.currentThread().getName()+" lo que imprimo es: "+B);
    }
    
    public void terminarDeImprimirB(){
        System.out.println("Ya termine de imprimir, soy "+Thread.currentThread().getName());
        cantActualB--;
        semB.release();
    }
    
    public synchronized void imprimir(char AB)throws InterruptedException{
        if(cantMaxA<cantActualA && cantMaxB<cantActualB){
            this.wait();
        }
        if(cantMaxA>cantActualA){
            this.imprimirEnA(AB);
            this.terminarDeImprimirA();
        }else{
            this.imprimirEnB(AB);
            this.terminarDeImprimirB();
        }
    }
}
