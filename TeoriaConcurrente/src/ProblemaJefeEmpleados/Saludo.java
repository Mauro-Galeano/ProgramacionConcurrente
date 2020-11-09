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

    private int llegaron;
    private Semaphore semJefe;
    private boolean saludar = false;

    public Saludo() {
        llegaron = 0;
        semJefe = new Semaphore(0);
    }

    synchronized void esperarJefe(String empleado) {
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
    }

    synchronized void saludoJefe(int numEmp) throws InterruptedException {
        if (llegaron < numEmp) {
            System.out.println("...ESPERANDO...");
            this.wait();
        }
        System.out.println("JEFE> Buenos dias!");
        saludar=true;
        notifyAll();
    }
}
