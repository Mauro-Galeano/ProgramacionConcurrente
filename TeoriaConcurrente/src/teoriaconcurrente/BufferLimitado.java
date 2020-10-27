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
        semB = new Semaphore(0);//Podria ser un contador, o una estructura de datos.
        mutex=new Semaphore(1);
        capacidad = n;//capacidad maxima
    }

    public void sacar() throws InterruptedException {
        if (semB.availablePermits() > 0) {//controlo que el buffer no este vacio
            //semC.acquire();
            Thread.sleep(1000);
            mutex.acquire();
            semB.acquire();//saco un elemneto a al buffer 
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy consumiendo un elemento, la cantidad de elementos del buffer ahora es: " + semB.availablePermits());
            mutex.release();
            semProd.release();//aviso al productor que hay un espacio vacio para agregar algo 
        } else {
            System.out.println("Soy "+Thread.currentThread().getName()+" el buffer esta vacio, debo esperar a que agreguen productos");
            semC.acquire();//bloqueo al consumidor hasta que agreguen algun producto
        }
    }

    public void agregar() throws InterruptedException {
        if (semB.availablePermits() < capacidad) {//controlo que el buffer no este lleno
            //semProd.acquire();
            Thread.sleep(1000);
            mutex.acquire();
            semB.release();//agrego algo al buffer
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy agregando un elemento, la cantidad de elementos del buffer ahora es: "+ semB.availablePermits());
            mutex.release();
            semC.release();//aviso al consumidor que hay algo para consumir
        } else {
            System.out.println("Soy "+Thread.currentThread().getName()+" el buffer esta lleno debo esperar a que consuman");
            semProd.acquire();//Para bloquear al productor en caso de que no haya espacio para agregar.
        }
        
    }
}
