/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto7;

/**
 *
 * @author carme
 */
public class Brazo implements Runnable {

    private Cinta caja;
    private int r;

    public Brazo(Cinta c) {
        caja=c;
    }

    public void run() {
        while (true) {
            r = (int) (Math.random() * 3) + 1;
            try {
                caja.colocarCaja(r * 10);
                Thread.sleep(2500);//simula quitar la caja
                caja.quitarCaja();
                Thread.sleep(2500);//simula poner la caja
            } catch (InterruptedException e) {
            }
        }

    }
}
