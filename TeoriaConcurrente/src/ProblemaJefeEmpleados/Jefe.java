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
public class Jefe implements Runnable{
    private String nombre;
    private int numEmp,llegaron;
    private Saludo saludo;
    
    public Jefe(Saludo s, String n, int x) {
        nombre = n;
        saludo = s;
        numEmp = x;
        llegaron=0;
    }
    
    public void run(){
        try{
            saludo.saludoJefe(numEmp);
        }catch(InterruptedException e){}
    }
}
