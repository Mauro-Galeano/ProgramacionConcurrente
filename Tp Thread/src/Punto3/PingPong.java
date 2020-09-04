/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

/**
 *
 * @author carme
 */
public class PingPong extends Thread {
    private String cadena;
    private int delay;
    
    public PingPong (String cad, int d){
        this.cadena=cad;
        this.delay= d;
    }
    public void run(){
        for(int i=1; i<delay; i++){
            System.out.println(cadena+" ");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }
}
