/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto6;

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
        Observatorio obs=new Observatorio();
        Persona[] colPersonas=new Persona[50];
        Thread[] colHilos=new Thread[50];
        for(int i=0;i<50;i++){
            colPersonas[i]= new Persona(obs);
            colHilos[i]=new Thread(colPersonas[i], "Persona"+i);
        }
        for(int i=0;i<50;i++){
            colHilos[i].start();
        }
    }
    
}
