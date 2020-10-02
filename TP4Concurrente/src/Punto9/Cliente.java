/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto9;

/**
 *
 * @author carme
 */
public class Cliente implements Runnable{
    private Taxi t;
    public Cliente(Taxi t1){
        this.t=t1;
    }
    
    
    private void buscarTaxi(){
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy buscando un taxi");
        try{
            Thread.sleep((int)Math.random()*1000);
        }catch(InterruptedException e){
            
        }
    }
    public void run(){
        this.buscarTaxi();
        if(t.subirAlTaxi()){
            t.solicitarViaje();
            System.out.println("Soy "+Thread.currentThread().getName()+" estoy viajando");
            t.bajarDelTaxi();
            System.out.println("Termine mi viaje, soy "+Thread.currentThread().getName());
        }else{
            System.out.println("El taxi estaba ocupado, soy "+Thread.currentThread().getName());
        }
    }
}
