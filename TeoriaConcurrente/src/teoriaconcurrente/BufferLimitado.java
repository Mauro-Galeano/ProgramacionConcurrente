/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriaconcurrente;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class BufferLimitado {

    private Semaphore semProd, semC, semB,mutex;
    private int capacidad, cont;

    public BufferLimitado(int n) {
        semProd = new Semaphore(0);
        semC = new Semaphore(0);
        semB = new Semaphore(0);
        mutex=new Semaphore(1);
        capacidad = n;//capacidad maxima
    }

    public void sacar() throws InterruptedException {
        if (semB.availablePermits() > 0) {
            //semC.acquire();
            Thread.sleep(1000);
            mutex.acquire();
            semB.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy consumiendo un elemento, la cantidad de elementos del buffer ahora es: " + semB.availablePermits());
            mutex.release();
            semProd.release();
        } else {
            System.out.println("Soy "+Thread.currentThread().getName()+" el buffer esta vacio, debo esperar a que agreguen productos");
            //semProd.release();
            semC.acquire();//bloqueo al consumidor hasta que agreguen algun producto
        }
    }

    public void agregar() throws InterruptedException {
        if (semB.availablePermits() < capacidad) {
            //semProd.acquire();
            Thread.sleep(1000);
            mutex.acquire();
            semB.release();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy agregando un elemento, la cantidad de elementos del buffer ahora es: "+ semB.availablePermits());
            mutex.release();
            semC.release();
        } else {
            System.out.println("Soy "+Thread.currentThread().getName()+" el buffer esta lleno debo esperar a que consuman");
            //semC.release();
            semProd.acquire();//Para bloquear al productor en caso de que no haya espacio para agregar.
        }
        
    }
}
