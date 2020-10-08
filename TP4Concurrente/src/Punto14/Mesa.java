/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto14;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Mesa {

    private Semaphore semMZ, semM, semE, semC;

    public Mesa() {
        semM = new Semaphore(1);
        semMZ = new Semaphore(0);
        semC = new Semaphore(0);
        semE = new Semaphore(0);
    }

    //Metodos del Empleado
    public void sentarme() throws InterruptedException{
        semM.acquire();
    }
    
    public void solicitarAtencionAlMozo() throws InterruptedException {
        System.out.println("Soy "+Thread.currentThread().getName()+" desearia tomar algo");
        semMZ.release();
    }
    
    public void elegirBebida() throws InterruptedException {
        semE.acquire();
        System.out.println(Thread.currentThread().getName() + " esta mirando el menu de bebidas...");
        Thread.sleep((int) Math.random() * 100);
        System.out.println(Thread.currentThread().getName() + " a elegido su bebida");
        semMZ.release();
    }

    public void solicitarComida() throws InterruptedException {
        semE.acquire();
        System.out.println("Soy "+Thread.currentThread().getName()+" desearia comer algo, me puede mostar el menu");
        semC.release();
    }

    public void elegirComida() throws InterruptedException {
        semE.acquire();
        System.out.println(Thread.currentThread().getName() + " esta mirando el menu de comidas...");
        Thread.sleep((int) Math.random() * 100);
        System.out.println(Thread.currentThread().getName() + " a elegido lo que desea comer");
        semC.release();
    }

    public void comerYBeber() throws InterruptedException {
        semE.acquire();
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy comiendo");
        Thread.sleep((int) Math.random() * 1000);
        System.out.println("Soy "+Thread.currentThread().getName()+" termine de comer");
    }
    
    public void retirarmeDeLaMesa() {
        System.out.println("La comida estuvo muy rica, muchas gracias por su atencion, soy " + Thread.currentThread().getName()+" me retiro.");
        semM.release();
    }
    
    //Metodos del mozo
    public void mostrarMenuDeBebidas() throws InterruptedException {
        semMZ.acquire();
        System.out.println("Hola mi nombre es " + Thread.currentThread().getName() + " soy el mozo, que desea tomar?");
        semE.release();
    }

    public void entregarBebida() throws InterruptedException {
        semMZ.acquire();
        System.out.println("Su pedido esta listo, puede servirse");
        semE.release();
    }

    //Metodos del cocinero
    public void mostrarMenuDeComidas() throws InterruptedException {
        semC.acquire();
        System.out.println("Hola mi nombre es " + Thread.currentThread().getName() + " soy el cocinero, que desea comer?");
        semE.release();
    }

    public void entregarComida() throws InterruptedException {
        semC.acquire();
        System.out.println("Su pedido esta listo, puede comer");
        semE.release();
    }
}
