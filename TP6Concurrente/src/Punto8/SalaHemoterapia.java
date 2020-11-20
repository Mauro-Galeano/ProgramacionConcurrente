/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/**
 *
 * @author carme
 */
public class SalaHemoterapia {
    private Lock accesoCamillas,accesoRevista;
    private Condition camilla,revista;
    private int contCamillas,contRevistas;
    public SalaHemoterapia(){
        accesoCamillas= new ReentrantLock();
        camilla= accesoCamillas.newCondition();
        //accesoRevista= new ReentrantLock();
        //revista= accesoRevista.newCondition();
        contCamillas=0;
        contRevistas=0;
    }
    
    public void entrar()throws InterruptedException{
        if(contCamillas<4){
            this.sentarmeEnLaCamilla();
        }else{
            this.leerRevista();
            this.sentarmeEnLaCamilla();
        }
        Thread.sleep(2500);//simulo que le sacan sangre
        this.salirDeLaSala();
    }
    
    private void sentarmeEnLaCamilla()throws InterruptedException{
        accesoCamillas.lock();
        while(contCamillas>4){//4 es la cantida de camillas que tengo
            camilla.await();
        }
        contCamillas++;
        System.out.println("Soy "+Thread.currentThread().getName()+" pude sentarme, voy sacarme sangre");
        accesoCamillas.unlock();
    }
    
    private void salirDeLaSala(){
        accesoCamillas.lock();
        contCamillas--;
        System.out.println("Soy "+Thread.currentThread().getName()+" ya me saque sangre me voy");
        camilla.signal();
        accesoCamillas.unlock();
    }
    
    private void leerRevista() throws InterruptedException{
        accesoCamillas.lock();
        if(contRevistas>8){//8 xq 9 es la cantida de revistas que tengo
            System.out.println("Soy "+Thread.currentThread().getName()+" voy a mirar tele porque no hay mas revistas");
            camilla.await();
        }else{
            contRevistas++;
            System.out.println("Soy "+Thread.currentThread().getName()+" estoy en la sala de espera, voy a leer una revista");
            camilla.await();
            contRevistas--;
        }
        accesoCamillas.unlock();
    }
    //puedo agregar el soltar revista y que cuando suelte una revista hacer camilla.signal() y de esta manerava a verificar si puede antenderse
    //y como no va a poder va a intentar una revista nuevamente?.
//    private void soltarRevista(){
//        accesoCamillas.lock();
//        System.out.println("Soy "+Thread.currentThread().getName()+"");
//        camilla.signal();
//        accesoCamillas.unlock();
//    }
}
