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
    private String nombre;
    //private int orden;
    public Atleta(Testigo t, String n) {
        testigo = t;
        nombre=n;
    }
    

    public void run() {
//        try {
//            switch (nombre) {
//                case "Atleta0":
//                    testigo.correrAtleta1();
//                    break;
//                case "Atleta1":
//                    testigo.correrAtleta2();
//                    break;
//                case "Atleta2":
//                    testigo.correrAtleta3();
//                    break;
//                case "Atleta3":
//                    testigo.correrAtleta4();
//                    break;
//            }
//        } catch (InterruptedException e) {
//        }
        
        try{
            testigo.correrAtleta();
        }catch(InterruptedException e){}
    }

}
