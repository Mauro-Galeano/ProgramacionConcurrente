/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilon;

/**
 *
 * @author carme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        Barberia barb = new Barberia();
        Barbero barbero = new Barbero(barb);

        Thread hiloBarbero = new Thread(barbero);
        hiloBarbero.start();
        Thread[] hiloClientes = new Thread[5];

        for (int i = 0; i < 5; i++) {
            Cliente cliente = new Cliente(barb, "Cliente " + i);
            hiloClientes[i] = new Thread(cliente);
        }
        for (int x = 0; x < 5; x++) {
            hiloClientes[x].start();
            try {
                Thread.sleep((int) (Math.random() * 440));
            } catch (InterruptedException e) {
            }
        }
    }
    
}
