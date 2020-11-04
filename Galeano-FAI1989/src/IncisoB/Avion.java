/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IncisoB;

/**
 *
 * @author carme
 */
public class Avion implements Runnable{
     private Pista pista;
    private int r;//random para aterrizar o despegar

    public Avion(Pista p) {
        pista = p;
        r =(int) (Math.random() * 2) + 1;
    }

    public void run() {

        try {
            switch (r) {
                case 1:
                    //System.out.println("Estoy volando quiero aterrizar, soy " + Thread.currentThread().getName());
                    //pista.comunicarmeConLaTorre(r);
                    pista.aterrizar(r);
                    break;
                case 2:
                    //System.out.println("Estoy es tierra quiero despegar, soy " + Thread.currentThread().getName());
                    //pista.comunicarmeConLaTorre(r);
                    pista.despegar(r);
                    break;
            }
        } catch (InterruptedException e) {
        }
    }
}
