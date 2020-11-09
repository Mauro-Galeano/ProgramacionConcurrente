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
public class Empleado implements Runnable{
    private String nombre;
    private Saludo saludo;
    
    public Empleado(Saludo s, String n) {
        nombre = n;
        saludo = s;
    } 
    
    public void run(){
        saludo.esperarJefe(nombre);
    }
}
