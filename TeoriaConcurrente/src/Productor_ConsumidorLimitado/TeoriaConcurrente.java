/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productor_ConsumidorLimitado;

/**
 *
 * @author carme
 */
public class TeoriaConcurrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int capacidadMaxima=2;
        BufferLimitado buffer= new BufferLimitado(capacidadMaxima);
        Consumidor c1=new Consumidor(buffer);
        Productor p1=new Productor(buffer);
        Thread hilo1=new Thread(c1, "Consumidor");
        Thread hilo2=new Thread(p1, "Productor");
        
        hilo1.start();
        hilo2.start();
    }
    
}
