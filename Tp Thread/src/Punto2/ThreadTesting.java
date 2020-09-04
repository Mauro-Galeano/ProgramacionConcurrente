/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 *
 * @author carme
 */
public class ThreadTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        System.out.println("En el main");
    }
/*1) En mi caso siempre a mostrado por pantalla primero el mensaje en el main, el cual nos dice que el hilo que se esta ejecutando es el del main. 
     Solo una vez vi primero el cartel de la pila.
    */
}
