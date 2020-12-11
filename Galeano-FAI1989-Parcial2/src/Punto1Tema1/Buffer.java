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
    private Lock lockC1,lockC2;
    private Cola cola1,cola2;
    private Condition esperaC1,esperaC2;
    private int hayAlguienParaInsertar=0;
    public Buffer(){
        lockC1=new ReentrantLock();
        esperaC1= lockC1.newCondition();
        lockC2=new ReentrantLock();
        esperaC2= lockC2.newCondition();
        cola1=new Cola();
        cola2=new Cola();
    }
    //estado seria una seccion critica, deberia tener un mutex o loc solo para el?? que pasa cuando agregue el hayAlguien??
    public void insetar(int elemento){
        hayAlguienParaInsertar++;
        if(estado==1){
            lockC1.lock();
            System.out.println("Soy "+Thread.currentThread().getName()+" inserte en la cola 1 el elemento "+elemento);
            cola1.poner(elemento);
            hayAlguienParaInsertar--;
            //
            if(cola2.esVacia()&&hayAlguienParaInsertar==0){//si no hay nadie mas para insertar y la cola de extraccion esta vacia entonces cambio la funcion de las colas
                System.out.println("Ahora la cola para insertar es la cola 2");
                estado=2;//cambio de estado, ahora la cola 2 es en la que se inserta.
            }
            esperaC1.signalAll();//para avisar al extractor que se agrego algo para extraer de la cola 1 y que dicha cola ahora es la de extraccion.
            lockC1.unlock();
        }else{
            lockC2.lock();
            System.out.println("Soy "+Thread.currentThread().getName()+" inserte en la cola 2 el elemento "+elemento);
            cola2.poner(elemento);
            hayAlguienParaInsertar--;
            //
            if(cola1.esVacia()&&hayAlguienParaInsertar==0){//si no hay nadie mas para insertar y la cola de extraccion esta vacia entonces cambio la funcion de las colas
                System.out.println("Ahora la cola para insertar es la cola 1");
                estado=1;//cambio de estado, ahora la cola 1 es en la que se inserta.
            }
            esperaC2.signalAll();//para avisar al extractor que se agrego algo para extraer de la cola 2 y que dicha cola ahora es la de extraccion.
            lockC2.unlock();
        }
//        lockE.lock();
//        esperaE.signal();
//        lockE.unlock();
//        lockI.unlock();
    }
    
    
    public void extraer()throws InterruptedException{
        //lockE.lock();
        if(estado==2){//si el estado es 2 entonces debo extraer de la cola 1
            lockC1.lock();
            if(cola1.esVacia()){
                System.out.println("Soy "+Thread.currentThread().getName()+" la cola 1 esta vacia, debo esperar");
                esperaC1.await();//me duermo hasta que alla algo para extraer
            }else{
                System.out.println("Soy "+Thread.currentThread().getName()+" extraigo de la cola 1 el elemento "+cola1.obtenerFrente());
                cola1.sacar();
            }
            lockC1.unlock();
        }else{//el estado es 1 por lo tanto debo extraer de la cola 2
            lockC2.lock();
            if(cola2.esVacia()){
                System.out.println("Soy "+Thread.currentThread().getName()+" la cola 2 esta vacia, debo esperar");
                esperaC2.await();//me duermo hasta que alla algo para extraer
            }else{
                System.out.println("Soy "+Thread.currentThread().getName()+" extraigo de la cola 2 el elemento "+cola2.obtenerFrente());
                cola2.sacar();
            }
            lockC2.unlock();
        }
        //lockE.unlock();
    }
}
