/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto13;

/**
 *
 * @author carme
 */
public class Mozo implements Runnable{
    private Mesa mesa;
    
    public Mozo(Mesa m1){
        mesa=m1;
    }
    private void creandoPlatosNuevos(){
        System.out.println("Estoy creando platos nuevos");
    }
    public void run(){
        while(true){
        try{
            mesa.mostrarMenu();
            mesa.entregarPedido();
            this.creandoPlatosNuevos();
        }catch(InterruptedException e){}
        }
    }
    
}
