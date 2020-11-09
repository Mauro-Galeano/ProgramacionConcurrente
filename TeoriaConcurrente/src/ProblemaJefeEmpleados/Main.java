/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaJefeEmpleados;

/**
 *
 * @author carme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] nombresEmpleados = {"Pablo", "Luis", "Andrea",
            "Pedro", "Paula"};
        Saludo hola = new Saludo();
        Thread[] elPersonal = new Thread[6];
        elPersonal[0] = new Thread(new Jefe(hola, "JEFE", 5));
        for (int i = 1; i < 6; i++) {
            elPersonal[i] = new Thread(new Empleado(hola,nombresEmpleados[i - 1]));
        }
        for (int i = 0; i < 6; i++) {
            elPersonal[i].start();
        }
    }

}
