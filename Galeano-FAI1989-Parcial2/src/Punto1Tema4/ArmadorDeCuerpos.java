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
public class ArmadorDeCuerpos implements Runnable{
    private Taller taller;
    public ArmadorDeCuerpos(Taller t){
        taller=t;
    }
    public void run(){
        while(true){
            try{
                armarCuerpo();
                taller.dejarCuerpo();
            }catch(InterruptedException e){}
        }
    }
    public void armarCuerpo()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+": estoy cociendo un cuerpo");
        Thread.sleep(2500);
    }
}
