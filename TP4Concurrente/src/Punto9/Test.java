/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto9;

/**
 *
 * @author carme
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Taxi taxi= new Taxi();
        Conductor c= new Conductor(taxi);
        Thread conductor= new Thread(c);
        Cliente[] colClientes= new Cliente[10];
        Thread[] colHilos= new Thread[10];
        for(int i=0;i<10;i++){
            colClientes[i]= new Cliente(taxi);
            colHilos[i]= new Thread(colClientes[i]);
        }
        conductor.start();
        for(int j=0;j<10;j++){
            colHilos[j].start();
        }
    }
    
}
