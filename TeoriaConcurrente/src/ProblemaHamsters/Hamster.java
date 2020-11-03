/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaHamsters;

/**
 *
 * @author carme
 */
public class Hamster implements Runnable {

    private Plato comida;
    private Rueda ejercicio;
    private String miNombre;

    public Hamster(Plato miComida,Rueda miEjercicio,String nombre){
        comida=miComida;
        ejercicio=miEjercicio;
        miNombre=nombre;
    }

    public void run() {
        while (true) {
            comida.empezarAComer(miNombre);
            try {
                Thread.sleep((long) Math.random() * 1500);
            } catch (InterruptedException ex) {
            }
            comida.terminarDeComer(miNombre);
            ejercicio.rodar(miNombre);
            
        }
    }

}
