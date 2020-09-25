/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Turno {
    private Semaphore semA, semB,semC;
    public Turno(){
       semA= new Semaphore(1);
       semB= new Semaphore(0);
       semC= new Semaphore(0);
    }
//    public void imprimir(String n,int cant){
//        if(n.equalsIgnoreCase("A") && semA.tryAcquire()){
//            for(int i=0;i<cant;i++){
//                System.out.print("A");
//            }
//            semB.release();
//        }else{
//            if(n.equalsIgnoreCase("B") && semB.tryAcquire()){
//            for(int i=0;i<cant;i++){
//                System.out.print("B");
//            }
//            semC.release();
//            }else{
//                if(n.equalsIgnoreCase("C") && semC.tryAcquire()){
//                    for(int i=0;i<cant;i++){
//                        System.out.print("C");
//                    }
//                    semA.release();
//                }
//            }
//        }
//   }
    public void imprimirA(int cant){
        try{
        semA.acquire();
        }catch(InterruptedException e){
        }
        for(int i=0;i<cant;i++){
                System.out.print("A");
            }
            semB.release();
    }
    public void imprimirB(int cant){
        try{
            semB.acquire();
        }catch(InterruptedException e){
        }
        for(int i=0;i<cant;i++){
                System.out.print("B");
            }
            semC.release();
    }
    public void imprimirC(int cant){
        try{
            semC.acquire();
        }catch(InterruptedException e){
        }
        for(int i=0;i<cant;i++){
                System.out.print("C");
            }
            semA.release();
    }
}
