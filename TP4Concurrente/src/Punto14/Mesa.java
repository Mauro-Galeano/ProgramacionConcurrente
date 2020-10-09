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

    private Semaphore semMZ, semM, semE, semC,semM2;

    public Mesa() {
        semM = new Semaphore(1);
        semM2= new Semaphore(1);
        semMZ = new Semaphore(0);
        semC = new Semaphore(0);
        semE = new Semaphore(0);
    }

    //Metodos del Empleado
    public int sentarme() throws InterruptedException{
        int num=0;
        if(semM.tryAcquire()){
            System.out.println("Pude sentarme en la mesa 1, soy " + Thread.currentThread().getName());
            num=1;
        }else{
            if(semM2.tryAcquire()){
                System.out.println("Pude sentarme en la mesa 2, soy " + Thread.currentThread().getName());
                num=2;
            }
        }
        return num;
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
    
    public void retirarmeDeLaMesa(int sillaALiberar) {
        System.out.println("La comida estuvo muy rica, muchas gracias por su atencion, soy " + Thread.currentThread().getName()+" me retiro.");
        switch(sillaALiberar){
            case 1:
                System.out.println("Silla 1 libre");
                semM.release();
                break;
            case 2:
                System.out.println("Silla 2 libre");
                semM2.release();
                break;
        }
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
