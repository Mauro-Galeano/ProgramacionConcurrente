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
public class Costurera implements Runnable{
    private Taller taller;
    public Costurera(Taller t){
        taller=t;
    }
    public void run(){
        while(true){
            try{
                cocerManga();
                taller.dejarManga();
            }catch(InterruptedException e){}
        }
    }
    
    public void cocerManga()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+": estoy cociendo una manga");
        Thread.sleep(2500);//simulo que coce una manga
    }
}
