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
public class Atleta implements Runnable {

    private Testigo testigo;

    public Atleta(Testigo t) {
        testigo = t;
    }

    public void run() {
        int corredorNumero = (int) (Math.random() * 4) + 1;
        try {
            switch (corredorNumero) {
                case 1:
                    testigo.correrAtleta1();
                    break;
                case 2:
                    testigo.correrAtleta2();
                    break;
                case 3:
                    testigo.correrAtleta3();
                    break;
                case 4:
                    testigo.correrAtleta4();
                    break;
            }
        } catch (InterruptedException e) {
        }
    }

}
