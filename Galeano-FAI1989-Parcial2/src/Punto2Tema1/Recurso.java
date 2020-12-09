/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2Tema1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Recurso {
    private Semaphore semTransbordador,espacios,semAutos;
    private int cantActual;
    public Recurso(){
        semTransbordador=new Semaphore(0);
        semAutos=new Semaphore(0);
        espacios=new Semaphore(10);
        cantActual=0;
    }
    public void subir()throws InterruptedException{
        espacios.acquire();
        System.out.println("Soy "+Thread.currentThread().getName()+" me subi al transbordador");
        cantActual++;
        if(cantActual==10){
            semTransbordador.release();
        }
    }
    
    public void bajar()throws InterruptedException{
        semAutos.acquire();
        System.out.println("Soy "+Thread.currentThread().getName()+" me bajo del transbordador, gracias por el viaje");
        //espacios.release();
        cantActual--;
        if(cantActual==0){
           semTransbordador.release();
        }else{
           semAutos.release();
        }
    }
    public void ir()throws InterruptedException{
        semTransbordador.acquire();
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy lleno, salimos");
    }
    
    public void avisarQueLLegamos()throws InterruptedException{
        System.out.println("Soy "+Thread.currentThread().getName()+" ya llegamos, pueden empezar a bajar");
        semAutos.release();
        semTransbordador.acquire();
    }
    
    public void volver()throws InterruptedException{
        System.out.println("Soy "+Thread.currentThread().getName()+" ya bajaron todos vuelvo");
        espacios.release(10);
        Thread.sleep(2500);//simula la vuelta
    }
    
}
