/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto5;

/**
 *
 * @author carme
 */
public class Cliente implements Runnable{
    private String name;
    
    public void run(){
        System.out.println("soy "+ Thread.currentThread().getName()+" de nombre "+this.name);
        Recurso.uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        };
    };
    
    public void setName(String nombre){
        this.name=nombre;
    }
  
}
