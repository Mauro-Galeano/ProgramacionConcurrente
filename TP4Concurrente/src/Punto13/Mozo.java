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
    private void buscarPedido(){
        System.out.println("Estamos preparando su pedido, soy"+Thread.currentThread().getName());
        try{
            Thread.sleep((int)Math.random()*1000);
        }catch(InterruptedException e){}
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
