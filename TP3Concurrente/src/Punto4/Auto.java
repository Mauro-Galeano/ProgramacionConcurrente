/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;

/**
 *
 * @author carme
 */
public class Auto extends Vehiculo implements Runnable {

    private Surtidor s;
    private String marca, patente, modelo;
    private int kmParaService, naftaActual, capacidad;

    public Auto(String pat, String model, String marca, Surtidor st) {
        this.marca = marca;
        this.modelo = model;
        this.patente = pat;
        this.capacidad=100;
        this.naftaActual=(int) (Math.random() * 50)+1;//Random entre 1 y 50.
        this.s=st;
    }

    public void andar() {
        int x=(int) (Math.random()*50)+1;
        try {
             if((naftaActual-x)>0){
                naftaActual=naftaActual-x;//Donde x es numero aleatorio
                 System.out.println("Esta andando el auto "+Thread.currentThread().getName()+" avanzo "+x+" km.");
                Thread.sleep(x*100);
             }
        } catch (InterruptedException e) {

        }

    }

    public void verificarNafta() {
        int cargar;
        if (naftaActual < 10) {
            cargar=calcularNaftaACargar();
            s.cargarNafta(cargar);
        }
    }
    
    public int calcularNaftaACargar(){
        int resta=capacidad-naftaActual;
        int x=(int) (Math.random()*resta)+1;//Este es un numero aleatorio.
        if(resta>0){
            naftaActual=naftaActual+x; //x es un numero aleatorio que va a estar entre 0 y el valor de resta
        }
        return x;
    }

    public void run() {
        while(true){
            this.andar();
            this.verificarNafta();
        }
    }
}
