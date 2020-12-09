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
public class Auto implements Runnable{
    private Recurso r;
    public Auto(Recurso r1){
        r=r1;
    }
    public void run(){
        try{
            r.subir();
            Thread.sleep(2000);
            r.bajar();
        }catch(InterruptedException e){}
    }
}
