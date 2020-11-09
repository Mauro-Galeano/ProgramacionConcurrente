/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilosofosCenando;

/**
 *
 * @author carme
 */
public class Filosofo implements Runnable {

    private Tenedor izquierdo, derecho;

    public Filosofo(Tenedor izq, Tenedor der) {
        izquierdo = izq;
        derecho = der;
    }

    public void comer() throws InterruptedException {
        System.out.println("Soy " + Thread.currentThread().getName() + " estoy comiendo");
        Thread.sleep(2500);
        System.out.println("Soy " + Thread.currentThread().getName() + " termine de comer");
    }

    public void run() {
        izquierdo.agarrar();
        derecho.agarrar();
        try {
            this.comer();
        } catch (InterruptedException e) {
        }
        izquierdo.soltar();
        derecho.soltar();

    }

}
