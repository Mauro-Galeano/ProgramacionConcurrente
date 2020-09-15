/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

/**
 *
 * @author carme
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Turno t= new Turno();
        Letra l= new Letra(t);
        Thread a= new Thread(l, "A");
        Thread b= new Thread(l, "BB");
        Thread c= new Thread(l, "CCC");
        
        a.start();
        b.start();
        c.start();
    }
    
}
