/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto12;

/**
 *
 * @author carme
 */
public class Hamsters implements Runnable{
    private String nombre;
    private Plato p;
    private Hamaca h;
    private Ruedita r;
    
    public Hamsters(String n, Plato p1, Hamaca h1, Ruedita r1){
        this.nombre=n;
        this.p=p1;
        this.r=r1;
        this.h=h1;
    }
    
    public void run(){
        p.Comer(nombre);
        h.descansar(nombre);
        r.subir(nombre);
    }
}
