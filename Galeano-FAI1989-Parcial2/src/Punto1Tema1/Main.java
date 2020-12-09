/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1Tema1;

/**
 *
 * @author carme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Buffer bf=new Buffer();
        Insertor insertor1= new Insertor(bf);
        Insertor insertor2= new Insertor(bf);
        Insertor insertor3= new Insertor(bf);
        Extractor extractor=new Extractor(bf);
        
        Thread e= new Thread(extractor, "Extractor");
        Thread i1= new Thread(insertor1, "Insertor 1");
        Thread i2= new Thread(insertor2, "Insertor 2");
        Thread i3= new Thread(insertor3, "Insertor 3");
        
        e.start();
        i1.start();
        i2.start();
        i3.start();
    }
    
}
