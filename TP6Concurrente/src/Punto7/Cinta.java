/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author carme
 */
public class Cinta {
    private int capacidadActual,capacidadMaxima,pesoMaximo,pesoActual;
    private Lock cinta,caja;
    private Condition accesoCinta,accesoCaja;
    private boolean hayCaja=false,cambiarCaja=false;
    public Cinta(int maximo){
        capacidadActual=0;
        capacidadMaxima=maximo;
        pesoActual=0;
        cinta= new ReentrantLock();
        caja=new ReentrantLock();
        accesoCinta= cinta.newCondition();
        accesoCaja= caja.newCondition();
    }
    public void tomarPastel()throws InterruptedException{//lo usa el empaquetador
        cinta.lock();
        while(0==capacidadActual){
            System.out.println("Soy "+Thread.currentThread().getName()+" la cinta esta vacia");
            accesoCinta.await();
        }
        capacidadActual--;
        System.out.println("Soy "+Thread.currentThread().getName()+" tomo un pastel en la cinta");
        cinta.unlock();
    }
    public void dejarPastel(int peso)throws InterruptedException{//lo usa el empaquetador
        caja.lock();
        if(!hayCaja){//si no hay caja que se duerma hasta que coloquen una
            accesoCaja.await();
        }
        while((peso+pesoActual)>pesoMaximo){
            System.out.println("Soy "+Thread.currentThread().getName()+" es demasiado peso para esta caja, debo esperar que la cambien");
            cambiarCaja=true;
            accesoCaja.await();
        }
        System.out.println("Soy "+Thread.currentThread().getName()+" dejo una torta en la caja");
        pesoActual=pesoActual+peso;
        caja.unlock();
    }
    public void dejarPastelEnCinta()throws InterruptedException{//lo usa el horno
        cinta.lock();
        while(capacidadActual==capacidadMaxima){
            System.out.println("Soy "+Thread.currentThread().getName()+" la cinta esta llena");
            accesoCinta.await();
        }
        capacidadActual++;
        System.out.println("Soy "+Thread.currentThread().getName()+" dejo un pastel en la cinta");
        accesoCinta.signalAll();
        cinta.unlock();
    }
    public void colocarCaja(int pM)throws InterruptedException{//lo usa el brazo
        caja.lock();
        while(hayCaja){
            System.out.println("Soy "+Thread.currentThread().getName()+" ya hay una caja debo esperar");
            accesoCaja.await();
        }
        pesoMaximo=pM;
        hayCaja=true;
        System.out.println("Soy "+Thread.currentThread().getName()+" coloco una caja, con un peso maximo de: "+pesoMaximo);
        accesoCaja.signalAll();
        caja.unlock();
    }
    public void quitarCaja()throws InterruptedException{
        while(!cambiarCaja){
            System.out.println("Soy "+Thread.currentThread().getName()+" todavia no debo cambiar la caja");
            accesoCaja.await();
        }
        hayCaja=false;
        System.out.println("Soy "+Thread.currentThread().getName()+" quito la caja");
    }
    
}
