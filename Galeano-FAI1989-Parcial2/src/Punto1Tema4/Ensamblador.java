/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1Tema4;

/**
 *
 * @author carme
 */
public class Ensamblador implements Runnable{
    private Taller taller;
    public Ensamblador(Taller t){
        taller=t;
    }
    public void run(){
        while(true){
            try{
                taller.armarSuerter();
            }catch(InterruptedException e){}
        }
    }
}
