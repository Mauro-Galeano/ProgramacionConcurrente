/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1Tema1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author carme
 */
public class Buffer {
    private int estado=1;//si el estado esta en 1 entonces la cola 1 es para insertar y la cola 2 para extraer
    private Lock lockE,lockI;
    private Cola cola1,cola2;
    private Condition esperaE;
    private int hayAlguienParaInsertar=0;
    public Buffer(){
        lockE=new ReentrantLock();
        esperaE= lockE.newCondition();
        lockI=new ReentrantLock();
        cola1=new Cola();
        cola2=new Cola();
    }
    
    public void insetar(int elemento){
        hayAlguienParaInsertar++;
        if(estado==1){
            lockI.lock();
            System.out.println("Soy "+Thread.currentThread().getName()+" inserte en la cola 1 el elemento "+elemento);
            cola1.poner(elemento);
            hayAlguienParaInsertar--;
            if(cola2.esVacia()&&hayAlguienParaInsertar==0){//si no hay nadie mas para insertar y la cola de extraccion esta vacia entonces cambio la funcion de las colas
                System.out.println("Ahora la cola para insertar es la cola 2");
                estado=2;//cambio de estado, ahora la cola 2 es en la que se inserta.
            }
        }else{
            lockI.lock();
            System.out.println("Soy "+Thread.currentThread().getName()+" inserte en la cola 2 el elemento "+elemento);
            cola2.poner(elemento);
            hayAlguienParaInsertar--;
            if(cola1.esVacia()&&hayAlguienParaInsertar==0){//si no hay nadie mas para insertar y la cola de extraccion esta vacia entonces cambio la funcion de las colas
                System.out.println("Ahora la cola para insertar es la cola 1");
                estado=1;//cambio de estado, ahora la cola 1 es en la que se inserta.
            }
        }
        lockE.lock();
        esperaE.signal();
        lockE.unlock();
        lockI.unlock();
    }
    
    
    public void extraer()throws InterruptedException{
        lockE.lock();
        if(estado==2){//si el estado es 2 entonces debo extraer de la cola 1
            if(cola1.esVacia()){
                System.out.println("Soy "+Thread.currentThread().getName()+" la cola 1 esta vacia, debo esperar");
                esperaE.await();//me duermo hasta que alla algo para extraer
            }else{
                System.out.println("Soy "+Thread.currentThread().getName()+" extraigo de la cola 1 el elemento "+cola1.obtenerFrente());
                cola1.sacar();
            }
        }else{//el estado es 1 por lo tanto debo extraer de la cola 2
            if(cola2.esVacia()){
                System.out.println("Soy "+Thread.currentThread().getName()+" la cola 2 esta vacia, debo esperar");
                esperaE.await();//me duermo hasta que alla algo para extraer
            }else{
                System.out.println("Soy "+Thread.currentThread().getName()+" extraigo de la cola 2 el elemento "+cola2.obtenerFrente());
                cola2.sacar();
            }
        }
        lockE.unlock();
    }
}
