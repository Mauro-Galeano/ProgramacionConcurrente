/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaJefeEmpleados;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Saludo {

    private int llegaron,cantSaludos;
    private boolean saludar = false;

    public Saludo() {
        llegaron = 0;
        cantSaludos=0;
    }

    synchronized void esperarJefe(String empleado) {
        System.out.println(empleado+" llega");
        llegaron++;
        if (llegaron == 5) {
            this.notifyAll();
        }
        while (!saludar) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
        System.out.println(empleado + "> Buenos dias jefe!");
        //forma 2 de mostrar el cartel.
//        cantSaludos++;
//        if(cantSaludos==5){
//            System.out.println("LISTO, ahora que todos han saludado - a trabajar");
//        }
    }

    synchronized void saludoJefe(int numEmp,String nombre) throws InterruptedException {
        System.out.println(nombre+" llega");
        if (llegaron < numEmp) {
            System.out.println("...ESPERANDO...");
            this.wait();
        }
        System.out.println("JEFE> Buenos dias!");
        saludar=true;
        notifyAll();
    }
}
