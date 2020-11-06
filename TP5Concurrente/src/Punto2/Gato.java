/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 *
 * @author carme
 */
public class Gato implements Runnable{
    private Comedor comedero;

    public Gato(Comedor c) {
        comedero = c;
    }

    public void run() {
        try {
            comedero.comerGato();
            comedero.terminarDeComerGato();
        } catch (InterruptedException e) {
        }
    }
}
