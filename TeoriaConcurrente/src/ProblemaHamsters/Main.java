/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaHamsters;

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
        Plato plato= new Plato(3);
        Rueda rueda= new Rueda();
        Hamster[] colHamsters= new Hamster[5];
        Thread[] colHilos= new Thread[5];
        for(int i=0;i<5;i++){
            colHamsters[i]=new Hamster(plato,rueda,"Hamster "+i);
            colHilos[i]=new Thread(colHamsters[i]);
        }
        for(int j=0;j<5;j++){
            colHilos[j].start();
        }
    }
    
}
