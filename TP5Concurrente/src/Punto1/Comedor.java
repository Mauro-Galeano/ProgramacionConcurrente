/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Comedor {

    private Semaphore cantComederos, mutex, semPerros, semGatos;
    private char turno = 'p';
    private int cantPlatosUsados, cantTotal;

    public Comedor(int cant) {
        cantPlatosUsados = 0;
        cantTotal = cant;
        cantComederos = new Semaphore(cantTotal);
        mutex = new Semaphore(1);
        semPerros = new Semaphore(cantTotal);
        semGatos = new Semaphore(0);
    }

    public boolean puedoEntrarPerro() {
        return (turno == 'p');
    }

    public void comerPerro() throws InterruptedException {
        //semBloqueo.acquire();//Para trabar a los gatos, ya que entro primero un perro.
        
            semPerros.acquire();
            mutex.acquire();
            if (cantPlatosUsados<cantTotal) {
                System.out.println("Soy " + Thread.currentThread().getName() + " entre al comedor, ya puedo comer");
                cantComederos.acquire();
                cantPlatosUsados++;
                //System.out.println(cantPlatosUsados);
                Thread.sleep(2500);
            }
            mutex.release();
        

    }

    public void terminarDeComerPerro() throws InterruptedException {
        mutex.acquire();
        cantComederos.release();
        cantPlatosUsados--;
        System.out.println("Soy " + Thread.currentThread().getName() + " termine de comer, me voy.");
        System.out.println(cantPlatosUsados);
        if (cantPlatosUsados == 0) {
            turno = 'g';
            semGatos.release(cantTotal);
        }
        mutex.release();
    }

    public boolean puedoEntrarGato() {
        //System.out.println(turno);
        return (turno =='g');
    }

    public void comerGato() throws InterruptedException {
        
            semGatos.acquire();
            mutex.acquire();
            if (cantPlatosUsados<cantTotal) {
                System.out.println("Soy " + Thread.currentThread().getName() + " entre al comedor, ya puedo comer");
                //cantComederos.acquire();
                cantPlatosUsados++;
                Thread.sleep(2500);
            }
            mutex.release();
        //}else{
            //System.out.println("No puedo entrar hay perros comiendo, soy "+Thread.currentThread().getName());
            //semGatos.acquire();
        
    }

    public void terminarDeComerGato() throws InterruptedException {
        mutex.acquire();
        cantComederos.release();
        cantPlatosUsados--;
        System.out.println("Soy " + Thread.currentThread().getName() + " termine de comer, me voy.");
        if (cantPlatosUsados == 0) {
            turno = 'p';
            //System.out.println("el turno es de "+turno);
            semPerros.release(cantTotal);
        }
        mutex.release();
    }
}
