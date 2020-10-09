/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto14;

/**
 *
 * @author carme
 */
public class Mozo implements Runnable {
     private Mesa mesa,mesa2;
    
    public Mozo(Mesa m1){
        mesa=m1;
    }
    private void creandoPlatosNuevos(){
        System.out.println("Voy a crear platos nuevos de pollo mientras espero que llegue mas gente");
    }
    public void run(){
        while(true){
        try{
            mesa.mostrarMenuDeBebidas();
            Thread.sleep((int) Math.random() * 1000);//simulo la busqueda de la bebida que pidio el cliente
            mesa.entregarBebida();
            this.creandoPlatosNuevos();
        }catch(InterruptedException e){}
        }
    }
}
