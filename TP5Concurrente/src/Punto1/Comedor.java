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

    private Semaphore mutex, semPerros, semGatos;
    private int cantPlatosUsados, cantTotal,cantPerros,cantGatos;
    public Comedor(int cant,int empieza,int cp,int cg) {
        cantPlatosUsados = 0;
        cantTotal = cant;
        mutex = new Semaphore(1);
        cantPerros=cp;
        cantGatos=cg;
        if(empieza==1){//si es 1 entran primero los perros
            semPerros = new Semaphore(cantTotal);
            semGatos = new Semaphore(0);
        }else{//si es 2 entran primero los gatos
            semPerros = new Semaphore(0);
            semGatos = new Semaphore(cantTotal);
        }
    }

    public void comerPerro() throws InterruptedException {
        semPerros.acquire();
        mutex.acquire();
        if (cantPlatosUsados < cantTotal) {
            System.out.println("Soy " + Thread.currentThread().getName() + " entre al comedor, ya puedo comer");
            cantPlatosUsados++;
            Thread.sleep(2500);//simula que come
        }
        mutex.release();
    }

    public void terminarDeComerPerro() throws InterruptedException {
        mutex.acquire();
        cantPlatosUsados--;
        System.out.println("Soy " + Thread.currentThread().getName() + " termine de comer, me voy.");
        cantPerros--;
        if (cantPlatosUsados == 0) {
            if(cantGatos>0){
                semGatos.release(cantTotal);
            }else{
                semPerros.release(cantTotal);
            }
            
        }
        mutex.release();
    }
    
    public void comerGato() throws InterruptedException {

        semGatos.acquire();
        mutex.acquire();
        if (cantPlatosUsados < cantTotal) {
            System.out.println("Soy " + Thread.currentThread().getName() + " entre al comedor, ya puedo comer");
            cantPlatosUsados++;
            Thread.sleep(2500);//simula que come
        }
        mutex.release();
    }

    public void terminarDeComerGato() throws InterruptedException {
        mutex.acquire();
        cantPlatosUsados--;
        System.out.println("Soy " + Thread.currentThread().getName() + " termine de comer, me voy.");
        cantGatos--;
        if (cantPlatosUsados == 0) {
            if(cantPerros>0){
                semPerros.release(cantTotal);
            }else{
                semGatos.release(cantTotal);
            }
            
        }
        mutex.release();
    }
}
