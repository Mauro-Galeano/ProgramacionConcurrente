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
    private int numSillas;
    public Empleado(Mesa m1) {
        mesa = m1;
    }

    public void run() {
        try {
            numSillas=mesa.sentarme();
            if(numSillas==1||numSillas==2){
            mesa.solicitarAtencionAlMozo();
            mesa.elegirBebida();
            mesa.solicitarComida();
            mesa.elegirComida();
            mesa.comerYBeber();
            mesa.retirarmeDeLaMesa(numSillas);
            }else{
                System.out.println("Vuelvo mas tarde, soy "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {}
    }
}
