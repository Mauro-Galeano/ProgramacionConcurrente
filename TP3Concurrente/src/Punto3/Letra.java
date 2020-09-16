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
public class Letra implements Runnable{
    private Turno turno;
    
    public Letra(Turno t){
        this.turno=t;
    }
   
   public void imprimir(){
        if(Thread.currentThread().getName().equals("A") && turno.getTurno()==1){
            System.out.print("A");
            turno.incrementar();
        }else{
            if(Thread.currentThread().getName().equals("BB") && turno.getTurno()==2){
            System.out.print("BB");
            turno.incrementar();
            }else{
                if(Thread.currentThread().getName()=="CCC"&&turno.getTurno()==3){
                    System.out.print("CCC");
                    turno.incrementar();
                }
            }
        }
   } 
    public void run(){
        this.imprimir();
    }
            
    
    
}
