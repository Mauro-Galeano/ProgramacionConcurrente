/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

/**
 *
 * @author carme
 */
public class Letra implements Runnable{
    private Turno turno;
    private String nombre;
    private int cantidadOcurrencias;
    public Letra(Turno t, int cant, String nom){
        this.turno=t;
        this.cantidadOcurrencias=cant;
        this.nombre=nom;
    }
   
   
    public void run(){
        while(true){
        turno.imprimir(nombre,cantidadOcurrencias);
        }
    }
}
