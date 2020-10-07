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
public class Cliente implements Runnable{
    private Mesa mesa;
    
    public Cliente(Mesa m1){
        mesa=m1;
    }
 
    public void run(){
        try{
            if(mesa.sentarme()){
                System.out.println("Pude sentarme, soy "+Thread.currentThread().getName());
                mesa.solicitarAtencion();
                mesa.elegirComida();
                mesa.comer();
                mesa.retirarmeDeLaMesa();
            }else{
                System.out.println("voy a seguir trabajando, vengo mas tarde");
            }
        }catch(InterruptedException e){
            
        }
    }
}
