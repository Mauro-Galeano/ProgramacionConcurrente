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
public class Cocinero implements Runnable {

    private Mesa mesa;

    public Cocinero(Mesa m1) {
        mesa = m1;
    }

    private void ordenarLaCocina() {
        System.out.println("Voy a ordenar la cocina, mientas espero mas clientes");
    }

    public void run() {
        while (true) {
            try {
                mesa.mostrarMenuDeComidas();
                Thread.sleep((int) Math.random() * 1000);//simulo lo que se tarda en cocinar el pedido
                mesa.entregarComida();
                this.ordenarLaCocina();
            } catch (InterruptedException e) {
            }
        }
    }
}
