/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

/**
 *
 * @author carme
 */
public class Perro implements Runnable {

    private Comedor comedero;

    public Perro(Comedor c) {
        comedero = c;
    }

    public void run() {
        //while (true) {
            try {
                //if (comedero.puedoEntrarPerro()) {
                    comedero.comerPerro();
                    comedero.terminarDeComerPerro();
                //}
            } catch (InterruptedException e) {
            }
        //}
    }
}
