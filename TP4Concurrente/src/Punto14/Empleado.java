/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto14;

/**
 *
 * @author carme
 */
public class Empleado implements Runnable {

    private Mesa mesa;

    public Empleado(Mesa m1) {
        mesa = m1;
    }

    public void run() {
        try {
            mesa.sentarme();
            System.out.println("Pude sentarme, soy " + Thread.currentThread().getName());
            mesa.solicitarAtencionAlMozo();
            mesa.elegirBebida();
            mesa.solicitarComida();
            mesa.elegirComida();
            mesa.comerYBeber();
            mesa.retirarmeDeLaMesa();
        } catch (InterruptedException e) {}
    }
}
