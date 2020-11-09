/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilon;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Barberia {
     Semaphore semBarbero, semBarberia, semCliente, semEsperas;
     

    public Barberia() {
        semBarbero = new Semaphore(0);
        semBarberia = new Semaphore(1, true);
        semCliente = new Semaphore(0, true); //Para la silla donde el barbero corta el pelo 
        //¿por que un barbero corta el pelo?
        //semEsperas = new Semaphore(5, true); //Para las sillas para esperar
    }

    public boolean entrarBarberia(String nombreCliente) {
        System.out.println("Soy el cliente " + nombreCliente + " y quiero entrar a la barberia");
        return (semBarberia.tryAcquire());
    }

    public synchronized void solicitoCorte(String nombreCliente) {
        System.out.println("Soy el cliente " + nombreCliente + " quiero atenderme");
        semBarbero.release();
        System.out.println("Soy " + nombreCliente + ", y me están cortando el pelo!");
        try {
            semCliente.acquire();
            //semEsperas.release(1);
        } catch (InterruptedException e) {}
    }

    public void terminarCorte() {
        semCliente.release();
    }

    public void salir() {
        semBarberia.release();
    }

    public void esperarCliente() {
        try {
            semBarbero.acquire();
        } catch (InterruptedException e) {}
    }
}
