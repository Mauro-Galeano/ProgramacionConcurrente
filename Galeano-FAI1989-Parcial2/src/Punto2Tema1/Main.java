/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2Tema1;

/**
 *
 * @author carme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Recurso r=new Recurso();
        Auto[] autos=new Auto[20];
        Thread[] hilos=new Thread[20];
        Transbordador transbordador=new Transbordador(r);
        Thread t= new Thread(transbordador, "Transbordador");
        for(int i=0;i<20;i++){
            autos[i]=new Auto(r);
            hilos[i]=new Thread(autos[i], "Auto "+i);
        }
        t.start();
        for(int i=0;i<20;i++){
            hilos[i].start();
        }
    }
    
}
