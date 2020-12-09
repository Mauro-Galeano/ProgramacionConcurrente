/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2Tema1;

/**
 *
 * @author carme
 */
public class Transbordador implements Runnable{
    private Recurso r;
    public Transbordador(Recurso r1){
        r=r1;
    }
    
    public void run(){
        while(true){
            try{
                //preparandoViaje();
                r.ir();
                Thread.sleep(2500);//simula el viaje
                r.avisarQueLLegamos();
                r.volver();
            }catch(InterruptedException e){}
        }
    }
    private void preparandoViaje(){
        try{
            Thread.sleep(2500);//simulo que preparan todo para un nuevo viaje
        }catch(InterruptedException e){}
        System.out.println("Soy "+Thread.currentThread().getName()+" ya estamos listos para un nuevo viaje, pueden emepzar a subir");
    }
}

