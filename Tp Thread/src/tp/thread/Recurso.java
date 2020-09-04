/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.thread;

/**
 *
 * @author carme
 */
public class Recurso {
    //El metodo uso, nos dice que hilo es el que tomo el "recurso" que para mi estaria siendo nuestro procesador.
    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("en Recurso: Soy" + t.getName());
    }
}

  
