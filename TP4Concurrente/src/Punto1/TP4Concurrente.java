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
public class TP4Concurrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Turno t= new Turno();
        Letra La= new Letra(t, 3, "A");
        Letra Lb= new Letra(t, 2, "B");
        Letra Lc= new Letra(t, 1, "C");
        Thread a= new Thread(La);
        Thread b= new Thread(Lb);
        Thread c= new Thread(Lc);
        
        a.start();
        b.start();
        c.start();
    }
    
}
