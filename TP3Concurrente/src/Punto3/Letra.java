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
   
   
    public void run(){
        while(true){
        turno.imprimir(Thread.currentThread().getName());
        }
    }
            
    
    
}
