/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;

/**
 *
 * @author carme
 */
public class Surtidor {
    public Surtidor(){
        
    }
    
    
    public synchronized void cargarNafta(int cargar){
        try{
            System.out.println("Esta cargando nafta el auto: "+Thread.currentThread().getName()+" esta cargando "+cargar );
            Thread.sleep(cargar*100);
            System.out.println("Termino de cargar"+Thread.currentThread().getName());
        }catch(InterruptedException e){
            
        }
        
    }
}
