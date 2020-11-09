/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaJefeEmpleados;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author carme
 */
public class Personal implements Runnable {

    private String nombre;
    private Saludo saludo;
    private boolean esJefe;
    static int llegaron = 0;
    private int numEmp;
    //private ReentrantLock lock=new ReentrantLock();
    private Semaphore semJefe= new Semaphore(0);
    Personal(Saludo s, String n) {
        esJefe = false;
        nombre = n;
        saludo = s;
    }

    Personal(Saludo s, String n, int x) {
        esJefe = true;
        nombre = n;
        saludo = s;
        numEmp = x;
    }

    public void run() {
        System.out.println("(" + nombre + " llega)");
        if (esJefe) {
            if (llegaron < numEmp) {
                System.out.println("(Esperando...)");
                try{
                    semJefe.acquire();
                }catch(InterruptedException e){}    
            }
            //saludo.saludoJefe();
        } else {
            synchronized (this) {
                llegaron++;
                if(llegaron==numEmp){
                    semJefe.release();
                }
            }
            saludo.esperarJefe(nombre);
        }
    }
}
